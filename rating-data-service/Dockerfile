FROM openjdk:21-jdk
LABEL authors="fiskandar"

WORKDIR /app
COPY target/rating-data-service-0.0.1-SNAPSHOT.jar /app/rating-data-service-0.0.1-SNAPSHOT.jar
EXPOSE 8083

CMD ["java", "-jar", "rating-data-service-0.0.1-SNAPSHOT.jar"]