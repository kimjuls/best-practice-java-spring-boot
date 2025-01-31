FROM --platform=linux/amd64 openjdk:17-jdk-alpine

COPY . .
RUN ./mvnw clean package

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]