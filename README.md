# metadata-direction-service
Microservice getting metadata from SqlLite DB for recommendation; Sky Hackathon 2023

Build:
./mvnw clean package

Example curl request:

curl -X POST http://localhost:8080/keybert-db -d '[{"topic":"From car", "weight":0.936}]' -H "Content-Type: application/json"
