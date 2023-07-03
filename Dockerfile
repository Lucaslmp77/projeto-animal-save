FROM maven:3.8.5-openjdk-18 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:18-ea-8-jdk-slim
COPY --from=build /target/Projeto-Animal-Save-0.0.1-SNAPSHOT.jar Projeto-Animal-Save.jar
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","Projeto-Animal-Save.jar"]