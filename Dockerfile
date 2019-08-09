FROM maven:3.6-jdk-11-slim as compile
WORKDIR	/build
COPY pom.xml
RUN mvn dependency:go-offline
COPY src /build/src/
RUN mvn clean package

FROM openjdk:11-jdk-slim
VOLUME /tmp
COPY --from=target /build/target/javalin-test-1.0-SNAPSHOT.jar app.jar
EXPOSE: 7000
ENTROPOINT java -jar app.jar
