# Stage 1: Build the application
# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY heapmate/ /app/
RUN mvn package

# Stage 2: Build the final image
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/heapmate*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
