# Docker command for MySQL
docker run -d --env MYSQL_ROOT_PASSWORD=root --env MYSQL_DATABASE=mytradingdb -p 3306:3306 --network=mytrading-network mysql:5.7

# Docker command for Jenksins
docker run -d -p 8888:8080 -v $HOME/jenkins-docker:/var/jenkins_home jenkinsci/blueocean:latest

#Jenksin URL
http://localhost:8888/blue
