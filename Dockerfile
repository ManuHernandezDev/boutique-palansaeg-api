# --- ETAPA 1: Construcción de la aplicación ---
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar archivos de configuración y dependencias
COPY pom.xml .
COPY src ./src

# Compilar el proyecto y generar el JAR (saltando las pruebas para agilizar)
RUN mvn clean package -DskipTests

# --- ETAPA 2: Ejecución ligera de la aplicación ---
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# 1. Crear un usuario no root para ejecutar la aplicación
RUN addgroup -S spring && adduser -u 1001 -G spring -D spring

# 2. Copiar el JAR asegurando que pertenezca al usuario creado
COPY --chown=spring:spring --from=build /app/target/*.jar app.jar

# 3. Cambiar al usuario no root
USER spring:spring

# Exponer el puerto de la API
EXPOSE 8080

# Comando para arrancar Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]