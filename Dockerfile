# FROM openjdk:latest
FROM openjdk:11-jre-slim-buster

# MAINTAINER "noisonnoiton" 
LABEL maintainer="noisonnoiton"

COPY target/rabbitmq-consumer-service-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-jar","/app.jar"]