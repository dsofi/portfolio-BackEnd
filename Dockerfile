FROM amazoncorretto:19-alpine-jdk
MAINTAINER dsofi
COPY target/segunda-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]