FROM openjdk:21-jdk
LABEL authors="fiskandar"

WORKDIR /app
COPY target/discovery-server-0.0.1-SNAPSHOT.jar /app/discovery-server-0.0.1-SNAPSHOT.jar
EXPOSE 8761

CMD ["java", "-jar", "discovery-server-0.0.1-SNAPSHOT.jar"]