
## Receive Service
###### The application is a piece of a distributed system that i'm working on to improve my skills on Spring Framework, specifically on Spring Boot

#### Which features are present?
* Spring Boot Core
* Spring JPA
* OpenAPI Swagger 3
* Docker
* Mockito
* JUnit 4/5
* Spring Cache (Redis)

#### Development process.
I am try use TDD to develop it, with small commits and inserting well practics when is possible.
It's not finished, am working on, but university is calling and i need do the activities and follow the course, and this is only free time, and restlessness(google translator)?
#### Core responsibility?

Well, the application will be responsible to administrate the receive of transport demands. When it receive a new demand, will prepare, save and send to Expediction Service work on.

#### How start it?
* start the Database first...
```
docker-compose up -d
```
* start the application...
```
mvn spring-boot:run
```

### Swagger 
```
http://localhost:8700/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/
```