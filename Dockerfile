FROM openjdk:11

ADD target/metadata.director-0.0.1-SNAPSHOT.jar metadata-director-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "metadata-director-service.jar"]

