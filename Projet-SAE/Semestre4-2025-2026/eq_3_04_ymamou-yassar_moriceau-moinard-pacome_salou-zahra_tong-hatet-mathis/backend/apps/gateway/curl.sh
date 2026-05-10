curl http://localhost:3000/api/test; echo \

curl http://localhost:3000/api/testAuth; echo \

curl -X POST http://localhost:3000/api/register \
  -H "Content-Type: application/json" \
  -d "{\"email\":\"test@mail.com\",\"username\":\"name\",\"password\":\"secret123\"}" \
  ; echo \

curl -X POST http://localhost:3000/api/login \
  -H "Content-Type: application/json" \
  -d "{\"email\":\"test@mail.com\",\"password\":\"secret123\"}" \
  ; echo \

curl http://localhost:3000/api/me \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2OWIxMzhmZTgyYzg3YzgwZGQyMTUwMzciLCJlbWFpbCI6InRlc3RAbWFpbC5jb20iLCJpYXQiOjE3NzMyMjIxNDMsImV4cCI6MTc3NTgxNDE0M30.5OPP8AAJjDGCUI1dfC926m_LenzNowxnwfxkuHU2Ol8"
