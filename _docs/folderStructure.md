
# Spring Boot Project Structure for ReelVault

This document outlines the full-fledged folder structure for a Spring Boot application named `ReelVault`.

## Project Structure

```
reelvault
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           └── reelvault
    │   │               ├── controller
    │   │               │   └── MovieController.java
    │   │               ├── service
    │   │               │   └── MovieService.java
    │   │               ├── repository
    │   │               │   └── MovieRepository.java
    │   │               ├── model
    │   │               │   └── Movie.java
    │   │               └── ReelVaultApplication.java
    │   ├── resources
    │   │   ├── static
    │   │   ├── templates
    │   │   └── application.properties
    └── test
        ├── java
        │   └── com
        │       └── example
        │           └── reelvault
        │               ├── controller
        │               ├── service
        │               ├── repository
        │               ├── model
        │               └── ReelVaultApplicationTests.java
```

## Folder Descriptions

- **mvnw, mvnw.cmd**: Maven Wrapper scripts for Unix-based and Windows systems, respectively. These scripts allow you to run Maven commands without having Maven installed globally.
- **pom.xml**: The Maven Project Object Model file that contains project configuration, dependencies, and build plugins.

### `src/main/java/com/example/reelvault`

- **controller**: Contains the REST controllers which handle HTTP requests and responses. Example: `MovieController.java`
- **service**: Contains the service classes which hold business logic. Example: `MovieService.java`
- **repository**: Contains the repository interfaces which handle data access and interaction with the database. Example: `MovieRepository.java`
- **model**: Contains the entity classes which represent the database tables. Example: `Movie.java`
- **ReelVaultApplication.java**: The main class for running the Spring Boot application.

### `src/main/resources`

- **static**: Contains static resources such as CSS, JavaScript, and images.
- **templates**: Contains server-side templates such as Thymeleaf templates.
- **application.properties**: Configuration file for Spring Boot application properties.

### `src/test/java/com/example/reelvault`

- **controller**: Contains unit tests for controller classes.
- **service**: Contains unit tests for service classes.
- **repository**: Contains unit tests for repository interfaces.
- **model**: Contains unit tests for entity classes.
- **ReelVaultApplicationTests.java**: Contains integration tests for the Spring Boot application.
