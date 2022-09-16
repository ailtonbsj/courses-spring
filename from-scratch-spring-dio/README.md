# Introdução ao framework Spring Boot
![](https://img.shields.io/badge/status-completed-brightgreen)

This course is part of Digital Innovation One at bootcamp of TQI Java Developer.

Creator: Rodrigo Peleias

## History of commands

```bash
# Running spring from terminal
./mvnw spring-boot:run

# Build project
./mvnw package

# Run jar package
java -jar target/dio-spring-0.0.1-SNAPSHOT.jar

# List content of jar package
jar tf dio-spring-0.0.1-SNAPSHOT.jar

# Running from terminal with properties: server.port --> SERVER_PORT
env SERVER_PORT=8081 APP_MESSAGE="New Text" ./mvnw spring-boot:run
```