FROM openjdk:11-jre-slim
WORKDIR /app
EXPOSE 8094
COPY target/conge-1.0.jar conge-service.jar
ENTRYPOINT ["java", "-jar", "/conge-service.jar"]