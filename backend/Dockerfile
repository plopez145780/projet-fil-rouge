FROM eclipse-temurin:25-jdk AS builder
WORKDIR /app

COPY pom.xml .
COPY .mvn ./.mvn
COPY src ./src
COPY mvnw .
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B
RUN ./mvnw package -DskipTests -B

FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
