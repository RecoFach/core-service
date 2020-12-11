# Core Service

Kotlin-based service connects services, users, frontend and database.

![Poster Core Service](./public/poster.png)

## Requirements

To run this project you need to install listed below tools:

- AdoptOpenJDK 11
- Kotlin
- Maven

To connect to MongoDB add the line like below in your
`src/main/resources/application.properties`:

```text
spring.data.mongodb.uri=mongodb+srv://<user>:<pass>@<url>/<db-name>
```

For more detailed guide see [Installation.md](docs/Installation.md)

## Endpoints and methods

All information about endpoints and http methods you
will find in [Endpoints.md](docs/Endpoints.md)

## Models

All models you will find in [Models.md](docs/Models.md)

## Technologies

- [Kotlin](https://kotlinlang.org/)
- [Spring Boot](https://spring.io/) framework to serve *REST API*
- [OAuth 2.0](https://tools.ietf.org/html/rfc6749) for Authentication
  and Authorization.
  