FROM openjdk:21-jdk
LABEL authors="fiskandar"

WORKDIR /app
COPY target/movie-info-service-0.0.1-SNAPSHOT.jar /app/movie-info-service-0.0.1-SNAPSHOT.jar
EXPOSE 8082

CMD ["java", "-jar", "movie-info-service-0.0.1-SNAPSHOT.jar"]