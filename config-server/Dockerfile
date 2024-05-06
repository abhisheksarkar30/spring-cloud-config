FROM bellsoft/liberica-openjdk-alpine
LABEL authors="abhisheksarkar30"
EXPOSE 8888
ENV APP_NAME=config-server
ADD target/${APP_NAME}*.jar ${APP_NAME}.jar
ENTRYPOINT java -jar ${APP_NAME}.jar