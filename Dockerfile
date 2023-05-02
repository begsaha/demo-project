FROM gradle:7.4.1 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:17-jre-slim
EXPOSE 8080
COPY --from=build /home/gradle/src/build/libs/demo-project-0.0.1-SNAPSHOT.jar /app/
RUN bash -c 'touch /app/demo-project-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/demo-project-0.0.1-SNAPSHOT.jar"]
