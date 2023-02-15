# Stage 1: Build the application
# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY heapmate/src/ /app/src/
RUN ls -la /app/
RUN ls -la /app/src/
RUN mvn package
RUN export APP_NAME=$(mvn help:evaluate -Dexpression=project.artifactId -q -DforceStdout) && \
    export APP_VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)

# Stage 2: Build the final image
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/${APP_NAME}-${APP_VERSION}.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
