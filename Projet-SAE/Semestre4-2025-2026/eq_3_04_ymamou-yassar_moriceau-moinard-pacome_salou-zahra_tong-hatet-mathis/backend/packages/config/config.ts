import type {Secret, SignOptions} from "jsonwebtoken"

export interface AppConfig {
	port: number
	host: string
	nodeEnv: string
	jwtSecret: Secret
	jwtExpiresIn: SignOptions["expiresIn"]
}

const toNumber = (value: string | undefined, fallback: number): number => {
	const parsed = Number(value)
	return Number.isFinite(parsed) && parsed > 0 ? parsed : fallback
}

const baseConfig = {
	host: process.env.HOST || "0.0.0.0",
	nodeEnv: process.env.NODE_ENV || "development",
	jwtSecret: (process.env.JWT_SECRET || "JWT_SECRET") as Secret,
	jwtExpiresIn: (process.env.JWT_EXPIRES_IN ?? "1h") as SignOptions["expiresIn"]
}

export const services = {
	auth: `http://localhost:${toNumber(process.env.AUTH_SERVICE_PORT, 3001)}`,
	users: `http://localhost:${toNumber(process.env.AUTH_SERVICE_PORT, 3001)}`,
	catalog: `http://localhost:${toNumber(process.env.CATALOG_SERVICE_PORT, 3002)}`,
	recommendation: `http://localhost:${toNumber(process.env.RECOMMENDATION_SERVICE_PORT, 3003)}`,
	planning: `http://localhost:${toNumber(process.env.PLANNING_SERVICE_PORT, 3004)}`
}
export const version = 1

export const base_url = {
	api: "/api/v" + version,
	jikan: process.env.JIKAN_API_URL || "https://api.jikan.moe/v4",
	yurippe: process.env.YURIPPE_API_URL || "https://yurippe.vercel.app/api/quotes"
}

export const animeFreshnessDuration = toNumber(process.env.ANIME_FRESHNESS_DURATION, 24 * 60 * 60 * 1000)
export const apiRateLimit = toNumber(process.env.API_RATE_LIMIT, 1050)
export const apiLengthLimit = toNumber(process.env.API_LENGTH_LIMIT, 5)


export const createServiceConfig = (portEnvName: string, defaultPort: number): AppConfig => ({
	...baseConfig,
	port: toNumber(process.env[portEnvName], defaultPort)
})

export const config = {
	...baseConfig,
	port: toNumber(process.env.PORT, 3000),
	services,
	base_url,
	animeFreshnessDuration,
	apiRateLimit,
	apiLengthLimit,
	version
}

export const needAuth = toNumber(process.env.NEED_AUTHENTICATION, 1) === 1

export default config
