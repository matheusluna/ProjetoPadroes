<%--
    Document   : cadastroCliente
    Created on : 16/04/2018, 01:46:19
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
          <label for="nome">Nome</label><br>
          <input type="text" id="nome" name="nome" value="" required><br>
          <label for="sobrenome">Sobrenome</label><br>
          <input type="text" id="sobrenome" name="sobrenome" value="" required><br>
          <label for="email">E-mail</label><br>
          <input type="email" id="email" name="email" value=""><br>
          <label for="senha">Senha</label><br>
          <input type="password" id="senha" name="senha" value=""><br>
          <input type="submit" name="" value="Salvar"><br>
          <span>${mensagem}</span>
          <input type="hidden" name="caminho" value="CadastroCliente">
        </form>
    </body>
</html>
