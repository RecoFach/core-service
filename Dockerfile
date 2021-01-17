# base image
FROM maven:3-alpine

# set home directory
WORKDIR /app

# copy source files to workdir
COPY . /app

# install dependencies
RUN mvn clean install -DskipTests

# package application
RUN mvn package

# exposing Port
EXPOSE 8080

# run application
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
