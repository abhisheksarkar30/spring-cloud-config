FROM bellsoft/liberica-openjdk-alpine
LABEL authors="abhisheksarkar30"
# Below is documentation of listening port which should be published to run a container of this image
EXPOSE 8080
# Spring Boot program value variables provided directly as System variables below
ENV spring.rabbitmq.host=host.docker.internal
ENV spring.rabbitmq.port=5672
ENV spring.profiles.active=nonprod
ENV spring.cloud.config.profile=dev
# Spring Boot program variable[spring.config.import] value provided through another System variable below
ENV CONFIG_SERVER_URL=http://host.docker.internal:8888
#ENV logging.file.path=logs/limits-service - logs persistence not required as of now for standalone docker container
ENV APP_NAME=limits-service
ADD target/${APP_NAME}*.jar ${APP_NAME}.jar
# Won't be able to override below ENTRYPOINT (in shell mode) while creating container, will be treated as start command
# no other java Program args could be appended with this, only solution docker --env variables
ENTRYPOINT java -jar ${APP_NAME}.jar