FROM bellsoft/liberica-openjdk-alpine
LABEL authors="abhisheksarkar30"
ADD target/config-server-*.jar config-server.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "config-server.jar"]