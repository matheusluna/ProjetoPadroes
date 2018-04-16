<%--
    Document   : index
    Created on : 16/04/2018, 01:44:20
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
        <form action="Frontal" method="post">
          <label for="email">E-mail</label><br>
          <input type="email" id="email" name="email" value=""><br>
          <label for="senha">Senha</label><br>
          <input type="password" id="senha" name="senha" value=""><br>
          <input type="submit" name="" value="Login"><br>
          <input type="hidden" name="caminho" value="LoginCliente">
        </form>
        <a href="cadastroCliente.jsp">cadastrar</a>
        <span>${mensagem}</span>
    </body>
</html>
