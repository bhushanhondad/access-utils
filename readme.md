## What is it?
This source code is an Spring Boot web application (mvc + thymeleaf).
 
Tested with
* Docker 19.03
* Ubuntu 19
* Java 8 or Java 11
* Spring Boot 2.2.4.RELEASE
* Maven

For explanation, please visit this article - [Docker and Spring Boot](https://mkyong.com/docker/docker-spring-boot-examples/)

## How to run this?
```bash
$ git clone git@github.com:bhushanhondad/access-utils.git
$ cd access-utils
$ mvn clean package
$ java -jar target/access-utils-1.0.jar

access http://localhost:8080/test

//dockerize

// create a docker image
$ sudo docker build -t access-utils:1.0 .
// run it
$ sudo docker run -d -p 8080:8080 -t access-utils:1.0

access http://localhost:8080/test
```
