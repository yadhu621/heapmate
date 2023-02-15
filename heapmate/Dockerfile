# Stage 1: Build the application
# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY heapmate/ /app/
# RUN mvn package

ARG APP_NAME=sampleapp
ARG APP_VERSION=1.0.0
RUN echo $APP_NAME $APP_VERSION

RUN mvn help:evaluate -Dexpression=project.artifactId -q -DforceStdout
RUN mvn help:evaluate -Dexpression=project.version -q -DforceStdout

# ARG APP_NAME=$(mvn help:evaluate -Dexpression=project.artifactId -q -DforceStdout)
# ARG APP_VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)
RUN echo $APP_NAME $APP_VERSION

# Stage 2: Build the final image
# FROM eclipse-temurin:17-jdk-alpine
# WORKDIR /app
# COPY --from=build /app/target/$APP_NAME-$APP_VERSION.jar /app/app.jar
# CMD ["java", "-jar", "/app/app.jar"]
