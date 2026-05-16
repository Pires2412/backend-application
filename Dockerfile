# =========================
# Etapa 1 - Build
# =========================
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copia primeiro o pom para aproveitar cache
COPY pom.xml .

# Baixa dependências antes
RUN mvn dependency:go-offline

# Copia o restante do projeto
COPY src ./src

# Gera o jar
RUN mvn clean package -DskipTests


# =========================
# Etapa 2 - Runtime
# =========================
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]