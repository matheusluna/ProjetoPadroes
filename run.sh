#criando imagem dp postgreSQL
docker build -t matheusluna/banco ./Banco
docker run -p 5433:5432 -d --name banco matheusluna/banco

#criando imagem da aplicação
mvn clean package
docker build -t matheusluna/apicacao .
docker run -p 8081:8080 -d --name app --link banco:host-banco matheusluna/apicacao
