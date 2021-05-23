#Base image
FROM openjdk:8-jdk-alpine

# Copy executable jar to the /tmp location in the image that is going to be created by the docker daemon
ADD target/api-gateway-0.0.1-SNAPSHOT.jar /tmp/api-gateway.jar

# Command to run the application the below execForm commands when the container is ready 
CMD ["java", "-Xms128m", "-Xmx128m", "-jar", "/tmp/api-gateway.jar"]

