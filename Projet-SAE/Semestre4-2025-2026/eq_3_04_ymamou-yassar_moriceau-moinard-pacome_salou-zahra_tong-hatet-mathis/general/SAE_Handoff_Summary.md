# SAE Handoff Summary

## 1) Initial Ideas & Brainstorming

We started with a broad reading of the subject: the SAE is not just "build an app," but to design an application on top of existing data sources and APIs, with a Node.js backend, communicating micro-services, and an Android native client. The early direction was to understand whether we were supposed to create an API, consume an existing API, or both. The conclusion was: both — consume existing APIs as sources, then expose our own backend services above them. This fits the subject's emphasis on source analysis, data quality, micro-services, and Android integration.

We explored several ideas:

- A classical manager app around anime discovery and cataloging
- A planner centered on current-season viewing
- A discovery app focused on recommendations and mood-based suggestions

We eventually converged on the classical manager direction, while keeping some useful ideas from the others:

- Basic search
- Personal recommendations
- Consistency checks between sources

We intentionally avoided locking ourselves into a feature-heavy concept too early, so the project can evolve safely during implementation.

---

## 2) Final Project Theme

The chosen theme is an **anime manager / discovery backend** built around:

- Anime search
- Anime detail aggregation
- User favorites
- Personal list management
- Profile visibility
- Potentially recommendations

The backend is designed to aggregate data from:

- **Jikan** (MAL API)
- **Yurippe** (anime quotes API)

> ⚠️ **Note**: AniList integration is planned (sourceIds field exists in DTO) but not yet implemented.

The core problem addressed is:

> "How can we build a clean, reliable, personalized anime experience by combining multiple external data sources with our own user data and business logic?"

This fits the subject's requirement to work from multiple APIs and sources while building a coherent backend architecture.

---

## 3) Objectives & Requirements

### Functional Objectives

The backend must support:

- User registration and login
- JWT authentication
- Current-user profile access
- Public profile access by username
- Favorites management
- Anime list management with rating/comment/status
- Anime catalog search and lookup
- Later: recommendations

### Technical Objectives

- A Node.js / Express backend
- A TypeScript codebase
- A micro-service architecture
- A gateway / proxy in front of internal services
- Clear separation of concerns
- Input validation (Zod)
- Reusable shared types/schemas
- A design that can be extended later
- Unit tests on service layer (white-box, Jest, mocked I/O)
- Integration tests on routes (black-box, Supertest + MongoMemoryServer)

### Academic Constraints

The subject expects:

- Micro-services communicating with one another
- Backend services that are deployable and documented
- Attention to quality of data
- Modelling choices that are justified
- Security considerations
- Tests and documentation
- A client-side Android integration

---

## 4) Architecture & Design Choices

### High-Level Architecture

```
Android client → Gateway → Internal micro-services → External APIs
```

The internal services currently are:

- `users_service`
- `catalog_service`
- `recommendation_service`
- `gateway`

### Why a Gateway?

The gateway is a single public entry point for the Android app. It:

- Forwards requests
- Centralizes authentication checks
- Hides internal service URLs
- Allows future aggregation of multiple services
- Keeps the mobile app simpler

We implemented it using a custom `httpCall` utility with `fetch` (see `gateway/src/utils/http.util.ts`).

### Stack

- TypeScript
- Express
- JWT
- bcryptjs
- Zod for runtime validation
- `fetch` in the gateway
- MongoDB with mongoose (using mongodb-memory-server for development)
- Monorepo layout with `apps/`, `packages/`, and shared code

### Shared Code

We introduced:

- `packages/shared` — common error classes, types, utilities
- `packages/config` — configuration, service URLs, JWT settings

### Data Model Choices

For now, we do not persist anime data as a Mongo collection. Instead:

- Anime data is fetched from external APIs
- Normalized via mappers
- Mapped to internal DTOs
- Only user-related data is stored in MongoDB models

This avoids duplicating large external datasets unnecessarily.

---

## 5) Implementation Details

### Current Monorepo Shape

```
backend/
├── apps/
│   ├── users_service/
│   ├── catalog_service/
│   ├── gateway/
│   └── recommendation_service/
└── packages/
    ├── config/
    └── shared/
```

### Users Service (Auth + Users)

The users service handles:

- Register
- Login
- Me (current user)
- User profile routes
- User favorites
- User list
- Profile visibility

**Current route shape:**

```typescript
// app.ts
app.use("/auth", authRouter);
app.use("/users", usersRouter);
```

**Auth routes** (`/auth`):

```typescript
authRouter.post("/register", validateData(RegisterSchema), register);
authRouter.post("/login", validateData(LoginSchema), login);
authRouter.get("/me", requireAuth, me);
```

**Users routes** (`/users`):

```typescript
// Own profile actions
usersRouter.get("/me", requireAuth, handleGetMe);
usersRouter.patch("/me/visibility", requireAuth, handleVisibilityChanges);

// List
usersRouter.get("/me/list", requireAuth, handleGetList);
usersRouter.patch("/me/list", requireAuth, handleAddOrUpdateAnimeIntoList);
usersRouter.delete(
  "/me/list/:id",
  validateParams(IdSchema),
  requireAuth,
  handleDeleteFromListById,
);

// Favorites
usersRouter.get("/me/favorites", requireAuth, handleGetFavorites);
usersRouter.put(
  "/me/favorites/:id",
  validateParams(IdSchema),
  requireAuth,
  handleAddToFavoriteById,
);
usersRouter.delete(
  "/me/favorites/:id",
  validateParams(IdSchema),
  requireAuth,
  handleRemoveFromFavoriteById,
);

// Public profile
usersRouter.get(
  "/profile/:username",
  validateParams(UsernameSchema),
  handleUserGetByUsername,
);
usersRouter.get(
  "/profile/:username/favorites",
  validateParams(UsernameSchema),
  handleGetFavoritesByUsername,
);
```

### Error Handling

We standardized on:

- Controllers calling `next(error)` in catch
- One global `app.use(errorHandler)` at the end of `app.ts`

The error handler pattern:

```typescript
export function errorHandler(
  error: unknown,
  _req: Request,
  res: Response,
  _next: NextFunction,
) {
  if (error instanceof AppError) {
    return res.status(error.status).json({
      error: error.code,
      message: error.message,
    });
  }

  console.error(error);
  return res.status(500).json({
    error: "INTERNAL_SERVER_ERROR",
  });
}
```

### User List / Favorites Model

The user model stores an anime list with per-anime metadata:

```typescript
animeEntrySchema = {
  animeId: Number, // required
  rating: Number, // 0-10, optional
  userComment: String, // default ""
  status: "watching" | "completed" | "dropped" | "plan_to_watch" | "on_hold",
  isFavorite: Boolean, // default false
};
```

We concluded that:

- IDs should be stored, not full anime objects
- Favorites should be derived from or synchronized with the anime list
- The list should support one entry per animeId
- Adding a favorite should create a minimal entry if needed

### Example Logic for Favorites

The approach for adding a favorite:

```typescript
export const addToFavoriteById = async (
  animeId: number,
  userId: string,
): Promise<void> => {
  const user = await UserModel.findById(userId);
  if (!user) {
    throw new NotFoundError("NO_USER_EXIST");
  }

  const existingEntry = user.animeList.find(
    (entry) => entry.animeId === animeId,
  );

  if (existingEntry) {
    existingEntry.isFavorite = true;
  } else {
    user.animeList.push({
      animeId,
      isFavorite: true,
      status: "completed", // Default status when favoriting
      userComment: "",
      rating: undefined,
    });
  }

  await user.save();
};
```

### Gateway

The gateway is implemented as a manual forwarding layer with a `httpCall` utility.

Structure:

- Routes
- Controllers
- `http.util.ts` for fetch calls
- Middlewares for auth and error handling

It forwards:

- Auth requests to `users_service`
- User requests to `users_service`
- Catalog requests to `catalog_service`
- (Later) recommendations

**Gateway routes** (prefixed with `/api/v0`):

```typescript
app.use("/api/v0/auth", authRoutes);
app.use("/api/v0/users", usersRoutes);
app.use("/api/v0/catalog", catalogRoutes);
```

### Catalog Service

The catalog service:

- Does not store anime persistently for now
- Fetches from external APIs (Jikan, Yurippe)
- Validates external payloads with Zod
- Maps them to internal DTOs
- Returns only the fields we care about

**Structure:**

- `providers/` → calling external APIs
- `schema/` → runtime validation (Zod)
- `mappers/` → transforming raw data into our format
- `dto/` → defining the official output shape

**Catalog routes** (`/catalog`):

```typescript
catalogRouter.get("/", getCatalogFiltered);
catalogRouter.get("/top", getCatalogFiltered);
catalogRouter.get("/:kind(type|category)/:q/top", getCatalogFiltered);
catalogRouter.get("/:kind(type|category)/:q", getCatalogFiltered);
catalogRouter.get("/anime/id/:animeId", getAnimeById);
catalogRouter.get("/anime/name/:q", getAnimeByName);
```

### Example of the Catalog Pipeline

```
External API → provider → schema validation → mapper → dto → controller → response
```

---

## 6) Problems Encountered & Solutions

### 1. Unclear Architecture: "Create API" vs "Use Existing API"

At first, it was unclear whether the project required:

- Only building an API
- Only using APIs
- Or both

We resolved this by understanding the subject as:

- Use external APIs as sources
- Build our own backend micro-services on top

### 2. DB or No DB?

We debated whether a persistent database was mandatory. The current implementation uses MongoDB with `mongodb-memory-server` for now, to keep the stack simple and validate architecture before committing to production persistence.

### 3. Favorites and List Modeling

We initially considered storing anime objects directly in the user model, but decided to store anime IDs and per-user metadata only, to avoid duplication and inconsistency.

### 4. Route Design

We refined routes multiple times:

- `favorite` → `favorites`
- POST/PUT/DELETE semantics on list/favorites
- `PATCH /me/visibility`
- Private routes under `/me`
- Public routes under `/profile/:username`

### 5. Error Handling

We standardized the pattern:

- Keep `next(error)` in controllers
- Remove route-level error handler usage
- Use a single global middleware in `app.ts`

### 6. Gateway Implementation

We simplified the gateway with a reusable `httpCall` utility in `http.util.ts` for cleaner fetch calls.

---

## 7) Current State of the Project

### Done

- [x] Project theme selected
- [x] API sources chosen (Jikan, Yurippe)
- [x] Architecture direction settled
- [x] Monorepo structure established
- [x] Users service implemented and stabilized
- [x] User profile / favorites / list routes defined
- [x] Error handling convention fixed
- [x] Gateway concept validated with `httpCall` utility
- [x] Catalog service logic clarified with providers/mappers/dto pattern
- [x] Route naming stabilized
- [x] Tests added for users_service and catalog_service

### In Progress

- [ ] Gateway implementation finalization
- [ ] Catalog service normalization and internal contract stabilization
- [ ] Recommendation service design and algorithms

### Still To Do

- [ ] Document the whole API
- [ ] Implement recommendation ranking
- [ ] Produce final diagrams and report content
- [ ] Create "automates" of each service
- [ ] Complete service-layer unit tests (white-box: UserModel, bcrypt mocked — priority)
- [ ] Add route integration tests with MongoMemoryServer (black-box: HTTP contract only)
- [ ] Decide whether to add persistent storage later

---

## 8) Documents & Deliverables

### Already Produced or Discussed

- A service architecture diagram for the SAE
- A Mermaid architecture version
- File outputs for the architecture diagram:
  - SVG
  - PNG
  - Mermaid source

### Drafted Content

We also outlined:

- Endpoint design
- Model design
- Gateway routing
- User/favorites/list structure
- Catalog service responsibilities

### Likely Final Deliverables Needed Later

- Architectural diagram
- Database / data model diagram if persistence is added later
- API documentation
- Test plan
- Possibly a presentation for the oral defense

---

## 9) Key Decisions & Tradeoffs

### 1. Gateway vs Direct Service Calls

We chose a gateway because it:

- Simplifies the Android client
- Centralizes authentication
- Hides internal topology

### 2. Persistent DB vs In-Memory

For now, we chose mongodb-memory-server style behavior to keep the project light and focus on architecture first.

### 3. Store Anime Objects vs IDs

We chose IDs only in the user side, to avoid data duplication and stale copies.

### 4. Public vs Private Profiles

We chose to support both:

- Private `/me`
- Public `/profile/:username`

With a visibility flag on the profile (`ghost`, `private`, `public`).

### 5. Favorites as Separate Resource vs List Flag

We modelled favorites as a state (`isFavorite`) on the user's anime entry, rather than a separate full object store.

### 6. Proxy Middleware vs Manual Gateway

We chose a manual gateway using `fetch` with an `httpCall` utility, because it is simpler, clearer, and closer to the rest of the codebase.

### 7. Catalog Persistence

We chose not to persist anime in Mongo for now, because the catalog is external-source driven and can be normalized on the fly.

---

## 10) Other Relevant Context

### Technical Direction

The work is currently centered on:

- Clean architecture
- Route stability
- Service boundaries
- Preparing a backend that can be extended without large refactors

### Practical Next Step

The next sensible milestone is to:

- Finish the gateway
- Freeze the catalog API contract
- Design the recommendation algorithm
- Document everything cleanly

---

## 11) Concise Project Snapshot

### In One Sentence

> This SAE is an anime discovery and management backend built with TypeScript, Express, JWT, and micro-services, consuming Jikan and Yurippe, with a manual gateway, user-centric list/favorites/profile logic, and a future path toward recommendations.

### Core Backend Modules

- `users_service`
- `catalog_service`
- `gateway`
- `recommendation_service`

### Core User-Facing Features

- Login/register
- Profile visibility (ghost/private/public)
- Personal list
- Favorites
- Public profile
- Anime lookup
- Recommendation (later)

---

## 12) Final Reference Snippet

### Current User-Side Model Direction

```typescript
animeList: [
  {
    animeId: number,
    rating?: number,             // 0-10
    userComment?: string,
    status: "watching" | "completed" | "dropped" | "plan_to_watch" | "on_hold",
    isFavorite: boolean
  }
]
```

### Current Private/Public Routing Logic

```
GET  /users/me
PATCH /users/me/visibility

GET    /users/me/list
PATCH  /users/me/list
DELETE /users/me/list/:id

GET    /users/me/favorites
PUT    /users/me/favorites/:id
DELETE /users/me/favorites/:id

GET /users/profile/:username
GET /users/profile/:username/favorites
```

### Service URLs (Default Ports)

| Service         | Port |
| --------------- | ---- |
| Gateway         | 3000 |
| Users Service   | 3001 |
| Catalog Service | 3002 |
| Recommendation  | 3003 |

---

## 13) Testing Strategy

### Philosophy

Testing is split into two distinct levels with different goals, tools, and rules. Mixing the two approaches leads to brittle, slow, or misleading test suites.

```
Service layer  → unit tests   → white-box  → mock I/O, assert internals
Route layer    → integration  → black-box  → real HTTP contract, MongoMemoryServer
```

---

### Level 1 — Service Unit Tests (Priority)

**Why services first?**

Controllers in this project are thin delegation wrappers. The real logic — including all security-critical invariants — lives in the service layer. A bug in a handler is immediately visible (wrong status code). A bug in a service can be completely silent: a user created with a plaintext password still returns 201.

**What to mock and why:**

| Dependency | Mock? | Reason |
|---|---|---|
| `UserModel` | ✅ Yes | Only real I/O — makes tests slow, flaky, and DB-dependent |
| `bcrypt` | ✅ Yes | Intentionally CPU-expensive by design (~300ms/call). Kills test suite performance at scale |
| `jwt` | ⚠️ Optional | Pure deterministic function — acceptable to run real, but mocking allows asserting exact arguments |
| `config` | ❌ No | Plain object, no side effects |

**What to assert (white-box):**

- `UserModel.create` receives `passwordHash`, never `password`
- `bcrypt.hash` is called with the correct salt rounds
- The correct `AppError` subclass and code is thrown per branch
- `jwt.sign` is called with the correct payload shape and secret

**Setup pattern:**

```typescript
jest.mock("../schema/user.schema");
jest.mock("bcryptjs");
jest.mock("jsonwebtoken");

beforeEach(() => jest.clearAllMocks());
```

No Mongo instance needed. No `beforeAll` startup cost. Tests run in milliseconds.

---

### Level 2 — Route Integration Tests

**Goal:** validate the HTTP contract — not the internal logic.

The service layer is already tested. Here we verify that:
- Routes are wired correctly
- Middleware chain works (auth, validation, error handler)
- Status codes and response shapes match the contract
- Edge cases are handled end-to-end (e.g. duplicate register → 409)

**MongoMemoryServer setup — `beforeAll`, not `beforeEach`:**

```typescript
let mongoServer: MongoMemoryServer;

beforeAll(async () => {
  mongoServer = await MongoMemoryServer.create(); // ~500ms, done once
  await mongoose.connect(mongoServer.getUri());
});

afterAll(async () => {
  await mongoose.disconnect();
  await mongoServer.stop();
});

afterEach(async () => {
  await UserModel.deleteMany({}); // reset data between tests, not the connection
});
```

Starting MongoMemoryServer in `beforeEach` would add ~500ms per test. With 20 tests that is 10 seconds of wasted setup. The connection is shared; only the data is reset.

Nothing is mocked at this level — bcrypt, jwt, and Mongo all run for real.

**What to assert (black-box):**

```typescript
const res = await request(app)
  .post("/auth/register")
  .send({ email: "x@x.com", username: "x", password: "pass" });

expect(res.status).toBe(201);
expect(res.body).toMatchObject({ username: "x" });
// No assertions on how it's done internally
```

---

### Priority Order

The `authRoutes.test.ts` and `usersRoutes.test.ts` files are currently empty. They should only be filled **after** service-layer coverage is complete — testing a route that delegates to untested service logic provides a false sense of security.

```
1. ✅ auth.service.ts        — registerUser, loginUser
2. ✅ users.service.ts       — favorites, list, visibility
3. ⏸  authRoutes.test.ts    — register + login HTTP contract
4. ⏸  usersRoutes.test.ts   — protected routes, auth middleware behavior
```

---

### Summary Table

| Layer | Test type | Approach | Mongo | bcrypt | jwt |
|---|---|---|---|---|---|
| `auth.service.ts` | Unit | White-box | ❌ Mocked | ❌ Mocked | ⚠️ Optional |
| `users.service.ts` | Unit | White-box | ❌ Mocked | ❌ Mocked | ❌ N/A |
| `authRoutes.test.ts` | Integration | Black-box | ✅ MongoMemoryServer | ✅ Real | ✅ Real |
| `usersRoutes.test.ts` | Integration | Black-box | ✅ MongoMemoryServer | ✅ Real | ✅ Real |
