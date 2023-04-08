#Start with a base image containing java
FROM openjdk:17-jdk-slim as build

MAINTAINER Clayton Gilbert "claytonwgilbert@gmail.com"

#Add application JAR to container
COPY ./target/accounts-microservice-0.0.1-SNAPSHOT.jar accounts-microservice-0.0.1-SNAPSHOT.jar

#Execute application
ENTRYPOINT ["java","jar","/accounts-microservice-0.0.1-SNAPSHOT.jar"]