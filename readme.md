# AF test - API

## Requirements

- OpenJDK 8

## Run Project

- mvn spring-boot:run

## API

- Access
  - Server is available on http://localhost:8080
  - Server API is available on http://localhost:8080/user/
  - Server Swagger UI is available on http://localhost:8080/swagger-ui/index.html

## DataSource

For dev purpose an in memory H2 database is available.
It will be reset each time as it is in memory.
To access the database:\
http://localhost:8080/h2-console/

- Driver: org.h2.Driver
- Url: jdbc:h2:mem:afDb
- User: af
- Password: af

## Architecture

This project is based on MVC Architecture
