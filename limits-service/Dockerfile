FROM bellsoft/liberica-openjdk-alpine
LABEL authors="abhisheksarkar30"
#ENV CONFIG_SERVER_URL=http://host.docker.internal:8888
ADD target/limits-service-*.jar limits-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "limits-service.jar"]
CMD ["--CONFIG_SERVER_URL=http://host.docker.internal:8888"]