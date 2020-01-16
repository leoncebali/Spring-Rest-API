
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
ADD spring-rest-api.jar spring-rest-api.jar
EXPOSE 3000
ENTRYPOINT exec java $JAVA_OPTS -jar spring-rest-api.jar

