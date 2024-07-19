FROM maven:3.6.3-openjdk-17
LABEL authors="jorelwall154"

WORKDIR /diary/

COPY .env .

COPY target/diary-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]