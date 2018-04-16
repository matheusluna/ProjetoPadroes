<%--
    Document   : cadastroAtendenteServico
    Created on : 16/04/2018, 05:20:21
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello</h1>
        <form action="Admin" method="post">
          <label for="[object Object]">Atendente</label><br>
          <input type="email" name="atendente" value=""><br>
          <label for="[object Object]">Serviço</label><br>
          <select name="servicoa">
            <c:forEach var="servico" items="${servicos}">
                <option value="${servico.id}">${servico.nome}</option>
            </c:forEach>
          </select><br>
          <label for="[object Object]">Tempo</label><br>
          <input type="number" name="tempo" value=""><br>
          <input type="submit" name="" value="Salvar">
          <input type="hidden" name="caminho" value="CadastroAtendenteServico">
        </form>
    </body>
</html>
