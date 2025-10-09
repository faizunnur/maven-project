# Stage 1: Build the application with Maven
FROM maven:3.9-eclipse-temurin-17-focal AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B package -DskipTests

# Stage 2: Create the final, small image with only the JRE
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
# Copy the built JAR from the 'build' stage
COPY --from=build /app/target/*.jar app.jar
# Expose the port the application runs on
EXPOSE 8080
# The command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]