# ----------------------------
# Build Stage
# ----------------------------
FROM eclipse-temurin:21-jdk AS build

WORKDIR /workspace

# Copy only pom.xml and mvnw first to cache dependencies
COPY ../transaction-aggregation-api-test/.mvn/ .mvn/
COPY mvnw pom.xml ./
RUN chmod +x mvnw

# Build dependencies only (no offline mode, faster)
RUN ./mvnw dependency:resolve

# Copy source code
COPY src ./src

# Build jar skipping tests (fast)
RUN ./mvnw clean package -DskipTests

# ----------------------------
# Runtime Stage
# ----------------------------
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy built jar
COPY --from=build /workspace/target/transaction-aggregation-api-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
