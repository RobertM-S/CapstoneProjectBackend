FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} fooddeliverybackend.jar

ENTRYPOINT ["java", "-jar", "/fooddeliverybackend.jar"]