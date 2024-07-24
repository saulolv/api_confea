# Stage 1: Build the application
FROM gradle:8.2.1-jdk17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle wrapper and project files
COPY gradle/ /app/gradle
COPY build.gradle /app/
COPY settings.gradle /app/
COPY src /app/src

# Build the application
RUN gradle clean build -x test

# Stage 2: Run the application
FROM eclipse-temurin:17-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the built application JAR from the previous stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the port on which the app will run
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
