<%--
    Document   : hora
    Created on : 16/04/2018, 15:23:33
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
        <h1>Hello World!</h1>
        <form action="Frontal" method="post">
          <label for="[object Object]">Horario</label><br>
          <select name="hora">
              <c:forEach var="h" items="${horarios}">
                  <option value="${h}">${h}</option>
              </c:forEach>
          </select><br>
          <input type="submit" name="" value="Salvar">
          <input type="hidden" name="caminho" value="CadastroAtendimentoCliente">
        </form>
    </body>
</html>
