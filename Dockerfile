FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . .
# RUN ./mvnw package

# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java", "-jar", "app.jar"]
ENTRYPOINT ["./mvnw", "spring-boot:run"]