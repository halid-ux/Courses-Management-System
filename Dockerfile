FROM amazoncorretto:17-alpine

ARG JAR_FILE=target/*.jar


COPY ${JAR_FILE} lab-0.0.1-SNAPSHOT.jar


EXPOSE 9191

ENTRYPOINT ["java", "-jar", "lab-0.0.1-SNAPSHOT.jar"]