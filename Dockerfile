FROM openjdk:24-slim-bullseye
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} microservicios-notas-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/microservicios-notas-0.0.1-SNAPSHOT.jar"]