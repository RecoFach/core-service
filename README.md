# Core Service

Kotlin-based service connects services, users, frontend and database.

![Poster Core Service](./public/poster.png)

## Requirements

To run this project you need to install listed below tools:

- AdoptOpenJDK 11
- Kotlin
- Maven

or Docker

To connect to MongoDB add the line like below in your
`src/main/resources/application.properties`:

```text
spring.data.mongodb.uri=mongodb+srv://<user>:<pass>@<url>/<db-name>
```

## Run

### Dev

To run this setup for development run following command:

```
./mvnw clean spring-boot:run
```

This will start dev server on `localhost` on `8080` port.

### Prod

For production, we use [Docker](https://docker.com/).


1. Build the docker image. You need specify version of backend service. 
   Ensure to replace `version` values with yours.

    ```docker
    docker build -t recofach-core .
    ```

1. Run the docker image. Ensure map `8080` port to needed one.

    ```docker
    docker run -p 8080:8080 \
    -e SPRING_DATA_MONGODB_URI="mongodb+srv://admin:admin@core-db.kkpqk.mongodb.net/core-db" \
    --name recofach-core recofach-core
    ```


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
  