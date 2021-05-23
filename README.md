# MyTrading Project
    
    Objective of this project is to provide a starting point and enable developers to learn/explore Microservices.
    In addition, extended it for learning Docker and Container technologies as well.
    Project exposes services to track or keep ledger of buying and selling of stocks.
    Handful of REST endpoints are exposed to perform crud operations.
    
    Technology Stack Used:
        - Spring Boot
        - Spring Cloud Framework
            - API Gateway
            - Spring Cloud Load Balancing - Client side load balancing
            - OpenFeign / REST Template
            - Eureka Naming Server
            - Zipking Distributed Tracing with RabbitMQ
            - Sleuth
        - Spring Data JPA
        - H2 In-Memory Database

# What Next?
    Replace H2 database with MySQL.
    Integrate with Jenkins CI/CD pipeline.
    Implement front end using Angular or React Framework.
    Implement unit testing using JUnit or Mockito Framework.
    

# Application URLs
    Eureka Naming Server  - http://localhost:8761
    Api Gateway           - http://locahost:8765
    Tax Service           - http://localhost:8100
    Trading Service       - http://localhost:8000
    Zipkin Tracing        - http://localhost:9411
    Jenkins CI/CD         - http://localhost:8888

# Docker commands
  #### List and remove unwanted docker images
    docker images
    docker image remove imageId [imageId] ...
  
  #### Build images
    docker build -t mkdocker5/naming-server:1.0.0-RELEASE . 
    docker build -t mkdocker5/api-gateway:1.0.0-RELEASE . 
    docker build -t mkdocker5/tax-service:1.0.0-RELEASE . 
    docker build -t mkdocker5/trading-service:1.0.0-RELEASE . 
  
  #### Push images to docker hub registry
    docker push mkdocker5/naming-server:1.0.0-RELEASE
    docker push mkdocker5/api-gateway:1.0.0-RELEASE
    docker push mkdocker5/tax-service:1.0.0-RELEASE
    docker push mkdocker5/trading-service:1.0.0-RELEASE
  
  #### Run docker containers
    docker run -p 9411:9411 -d openzipkin/zipkin:2.23
    docker run -p 8000:8000 -d mkdocker5/naming-server:1.0.0-RELEASE
    docker run -p 8000:8000 -d mkdocker5/api-gateway:1.0.0-RELEASE
    docker run -p 8000:8000 -d mkdocker5/tax-service:1.0.0-RELEASE
    docker run -p 8000:8000 -d mkdocker5/trading-service:1.0.0-RELEASE
    docker run -p 9411:9411 openzipkin/zipkin:2.23

  #### List, stop and prune stopped containers
    docker container ls -a
    docker container stop <containerId>
    docker container prune

  #### Run MySql DB in docker container
    docker run -d --env MYSQL_ROOT_PASSWORD=root --env MYSQL_DATABASE=mytradingdb -p 3306:3306 --network=mytrading-network mysql:5.7
    Credentials - root / root
  
  #### Run Jenkins in docker container
    docker run -d -p 8888:8080 -v $HOME/jenkins-docker:/var/jenkins_home jenkinsci/blueocean:latest
    Credentials - admin / admin

# Docker Compose Command
    docker-compose up

# Spring Boot and Dependencies
  #### Naming Server - Spring Cloud Netflix Eureka Server
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
  
  #### Naming Server Client - Spring Cloud Netflix Eureka Client
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
    
  #### Api Gateway - Spring Cloud Gateway
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-gateway</artifactId>
    </dependency>
    
  #### Invoke REST Endpoints - Spring Cloud Open Feign
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-openfeign</artifactId>
    </dependency>

  #### Logging - Sleuth, Zipkin Distributed Tracing with RabbitMQ
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-sleuth</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-sleuth-zipkin</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.amqp</groupId>
      <artifactId>spring-rabbit</artifactId>
    </dependency>

  #### Database - Spring Data JPA & H2 in-memory database
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
      <groupId>com.h2database</groupId>
      <artifactId>h2</artifactId>
    </dependency>
