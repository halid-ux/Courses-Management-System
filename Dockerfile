FROM amazoncorretto:17-alpine

# Copy the JAR file from the builder stage
COPY target/*.jar lab-0.0.1-SNAPSHOT.jar

# Make port 9191 available to the world outside this container
EXPOSE 9191

ENTRYPOINT ["java", "-jar", "lab-0.0.1-SNAPSHOT.jar"]
