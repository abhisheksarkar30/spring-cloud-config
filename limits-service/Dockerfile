FROM bellsoft/liberica-openjdk-alpine
LABEL authors="abhisheksarkar30"
EXPOSE 8080
ENV CONFIG_SERVER_URL=http://host.docker.internal:8888
ENV APP_NAME=limits-service
ADD target/${APP_NAME}*.jar ${APP_NAME}.jar
ENTRYPOINT java -jar ${APP_NAME}.jar