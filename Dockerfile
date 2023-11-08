FROM openjdk:11-jre-slim
WORKDIR /app
EXPOSE 8094
COPY target/conge-1.0.jar conge-service.jar
ENV SPRING_DATASOURCE_URL=jdbc:mysql://user-mysql:3306/userdb?useSSL=false
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=
ENTRYPOINT ["java", "-jar", "/conge-service.jar"]
