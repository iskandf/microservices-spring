FROM openjdk:21-jdk
LABEL authors="fiskandar"

WORKDIR /app
COPY target/movie-catalog-service-0.0.1-SNAPSHOT.jar /app/movie-catalog-service-0.0.1-SNAPSHOT.jar
EXPOSE 8081

CMD ["java", "-jar", "movie-catalog-service-0.0.1-SNAPSHOT.jar"]