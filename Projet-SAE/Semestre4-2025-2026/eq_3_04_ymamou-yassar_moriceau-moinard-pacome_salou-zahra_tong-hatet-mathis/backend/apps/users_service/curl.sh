curl http://localhost:3001/auth/test; echo \

curl -X POST http://localhost:3001/auth/register \
  -H "Content-Type: application/json" \
  -d "{\"email\":\"test@mail.com\",\"username\":\"name\",\"password\":\"secret123\"}" \
  ; echo \

curl -X POST http://localhost:3001/auth/login \
  -H "Content-Type: application/json" \
  -d "{\"email\":\"test@mail.com\",\"password\":\"secret123\"}" \
  ; echo \

curl http://localhost:3001/auth/me \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI2OWI4MWQwNTU2ZjgyMWFmMTkxODYyYzEiLCJlbWFpbCI6Im1haWxAbWFpbC5jb20iLCJ1c2VybmFtZSI6Impob24iLCJpYXQiOjE3NzM2NzM3MzMsImV4cCI6MTc3NjI2NTczM30.AZnCSEZOXspTqAC_rYRER4PCniElT_W6NkwyN0ogum4"
