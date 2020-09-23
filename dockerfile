FROM openjdk:8-jdk-alpine
ARG PROPIEDADES_FILE=target/application.properties
COPY ${PROPIEDADES_FILE} application.properties
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} pruebamainsoft.jar
ENTRYPOINT ["java","-jar", "-Dserver.port=8085","-Dspring.config.location=application.properties","/pruebamainsoft.jar"]
