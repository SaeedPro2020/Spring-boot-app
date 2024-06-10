# Use AdoptOpenJDK 11 as the base image
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file from the target directory to the container
COPY target/*.jar app.jar

# Specify the command to run your Spring Boot application
CMD ["java", "-jar", "app.jar"]
