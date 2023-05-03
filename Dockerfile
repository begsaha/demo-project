FROM gradle:7.4.1 AS build
# --chown is the permission for the =group:user and file copied in the /home/gradle/src directory is wrtiable
#through this useses of the group
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM bellsoft/liberica-openjre-alpine:17
EXPOSE 8080
COPY --from=build /home/gradle/src/build/libs/demo-project-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/demo-project-0.0.1-SNAPSHOT.jar"]
