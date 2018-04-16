<%--
    Document   : atendentes
    Created on : 16/04/2018, 06:32:39
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
        <h1>Olá</h1>
        <ul>
            <c:forEach var="a" items="${atendentes}">
                <li><a href="Admin?caminho=ServicoAtendente&email=${a.email}">${a.nome}</a></li>
            </c:forEach>
        </ul>
    </body>
</html>
