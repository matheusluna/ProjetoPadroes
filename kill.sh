mvn clean
docker stop app
docker rm app
docker rmi matheusluna/apicacao
docker stop banco
docker rm banco
docker rmi matheusluna/banco
