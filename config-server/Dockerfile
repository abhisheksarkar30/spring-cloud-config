FROM bellsoft/liberica-openjdk-alpine
LABEL authors="abhisheksarkar30"
# Below is documentation of listening port which should be published to run a container of this image
EXPOSE 8888
ENV APP_NAME=config-server
ADD target/${APP_NAME}*.jar ${APP_NAME}.jar
# Won't be able to override below ENTRYPOINT (in exec mode) while creating container, will be treated as start command
ENTRYPOINT ["java", "-jar", "config-server.jar"]
# Intentionally allowed to override below CMD while creating container, to be appended to above as java Program Args
CMD ["--spring.rabbitmq.host=host.docker.internal", "--spring.rabbitmq.port=5672"]