FROM eclipse-temurin:17.0.11_9-jre-focal
LABEL authors="abhisheksarkar30"
ADD target/config-server-*.jar config-server.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "config-server.jar"]