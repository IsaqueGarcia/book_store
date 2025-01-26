ARG APP_PATH="/app"
#Utilizei uma versão do maven referênciada aqui https://hub.docker.com/_/maven
FROM maven:3.9.9-eclipse-temurin-17 AS build
LABEL authors="Isaque Garcia"
#Pasta no container
ARG APP_PATH
WORKDIR $APP_PATH
#Copia os arquivos necessários para realizar o build da image
COPY pom.xml .
COPY src ./src
#Builda o projeto
RUN mvn clean package -DskipTests
#Referência https://stackoverflow.com/questions/69525199/openjdk-java-17-docker-image
FROM openjdk:17-jdk-slim
ARG APP_PATH
WORKDIR $APP_PATH
#Copia o jar buildado na pasta target no step build, para o container
ARG APP_PATH
COPY --from=build $APP_PATH/target/bookstore-0.0.1-SNAPSHOT.jar .
#Inicia a aplicação
CMD ["java", "-jar", "bookstore-0.0.1-SNAPSHOT.jar"]