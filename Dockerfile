FROM maven:3.6.3-openjdk-17
LABEL authors="jorelwall154"

WORKDIR /diary

COPY pom.xml .
COPY src/ ./src

RUN mvn package

COPY target/diary-0.0.1-SNAPSHOT.jar diary.jar

EXPOSE 8080
CMD ["java", "-jar", "diary.jar"]