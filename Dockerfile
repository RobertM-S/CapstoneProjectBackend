FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} FoodDeliveryBackend.jar

ENTRYPOINT ["java", "-jar", "/FoodDeliveryBackend.jar"]