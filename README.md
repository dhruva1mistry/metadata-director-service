# metadata-direction-service
Microservice getting metadata from SqlLite DB for recommendation; Sky Hackathon 2023

Build jar:
./mvnw clean package

jar location in repo: 
target/metadata.director-0.0.1-SNAPSHOT.jar

Build docker img:
docker build -t metadata-director-service .
docker tag metadata-director-service dhruvamist/metadata-director-service
docker login -u dhruvamist
docker push dhruvamist/metadata-director-service   
Using default tag: latest


Deploy in docker:
docker run -dp 80:8080 -name=metadata-director-service dhruvamist/metadata-director-service:latest


Example curl request (wip):
curl -X POST http://localhost:8080/keybert-db -d '[{"topic":"From car", "weight":0.936}]' -H "Content-Type: application/json"