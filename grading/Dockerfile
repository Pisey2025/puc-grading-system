# Use a base image with Java and Maven installed
FROM maven:3.9.3-eclipse-temurin-17 as build

# Set working directory
WORKDIR /app

# Copy everything to the container
COPY . .

# Build the application
RUN mvn clean package -DskipTests

# Second stage: Use lightweight JRE image
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy the jar from the first stage
COPY --from=build /app/target/grading-0.0.1-SNAPSHOT.jar app.jar

# Start the app
CMD ["java", "-jar", "app.jar"]
