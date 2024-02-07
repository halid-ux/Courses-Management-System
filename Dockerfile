FROM amazoncorretto:17-alpine

ARG JAR_FILE=target/*.jar

# Copy the JAR file from the builder stage
COPY ${JAR_FILE} lab-0.0.1-SNAPSHOT.jar

# Make port 9191 available to the world outside this container
EXPOSE 9191

ENTRYPOINT ["java", "-jar", "lab-0.0.1-SNAPSHOT.jar"]