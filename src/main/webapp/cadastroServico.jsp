<%--
    Document   : cadastroServico
    Created on : 16/04/2018, 05:05:50
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastre um serviço!</h1>
        <form action="Admin" method="post">
          <label for="[object Object]">nome</label><br>
          <input type="text" name="nome" value=""><br>
          <label for="[object Object]">preço</label><br>
          <input type="number" name="preco" value=""><br>
          <input type="hidden" name="caminho" value="CadastroServico">
          <input type="submit" name="" value="Salvar">
        </form>
    </body>
</html>
