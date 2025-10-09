# -------------------------------
# 1. Build do projeto
# -------------------------------
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /app

# Copiar arquivos do Maven
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Instalar bash e baixar dependências
RUN apk add --no-cache bash
RUN ./mvnw dependency:go-offline -B

# Copiar código fonte
COPY src ./src

# Build do projeto (ignora testes)
RUN ./mvnw package -DskipTests

# -------------------------------
# 2. Container final (runtime)
# -------------------------------
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copiar o JAR gerado no container de build
COPY --from=build /app/target/es2eventos-0.0.1-SNAPSHOT.jar app.jar

# Expor porta do Spring Boot
EXPOSE 8080

# Comando para rodar o Spring Boot
CMD ["java", "-jar", "app.jar"]
