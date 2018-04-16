<%-- 
    Document   : servicos
    Created on : 16/04/2018, 14:47:23
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
        <ul>
            <c:forEach var="servico" items="${servicos}">
                <li><a href="Admin?caminho=Dia&servico=${servico.id}">${servico.id}</a></li>
            </c:forEach>
        </ul>
    </body>
</html>
