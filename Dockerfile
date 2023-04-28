FROM openjdk:17
EXPOSE 8080
ADD build/libs/demo-project-0.0.1-SNAPSHOT.jar demo-project.jar
ENTRYPOINT["java", "-jar", "/demo-project.jar"]