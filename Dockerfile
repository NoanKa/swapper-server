# BUILD STAGE
FROM maven:4.0.0-rc-4-eclipse-temurin-21-alpine AS builder
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# RUN STAGE
FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar
EXPOSE 3000

ENTRYPOINT ["java", "-jar", "app.jar"]