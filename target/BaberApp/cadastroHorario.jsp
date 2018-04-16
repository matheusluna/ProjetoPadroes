<%--
    Document   : cadastroHorario
    Created on : 16/04/2018, 04:36:57
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
        <h1>Hello World!</h1>
        <form action="Admin" method="post">
          <label for="email">E-mail do atendete</label><br>
          <input type="email" name="atendente" value=""><br>
          <label for="nome">Hora de inicio</label><br>
          <input type="time" name="inicio" value=""><br>
          <label for="nome">Hora de saída</label><br>
          <input type="time" name="fim" value=""><br>
          <select name="diasemana">
            <option value="DOMINGO">Domingo</option>
            <option value="SEGUNDA">Segunda</option>
            <option value="TERÇA">Terça</option>
            <option value="QUARTA">Quarta</option>
            <option value="QUINTA">Quinta</option>
            <option value="SEXTA">Sexta</option>
            <option value="SÁBADO">Sábado</option>
          </select><br>
          <input type="submit" name="" value="Salvar">
          <input type="hidden" name="caminho" value="CadastroHorario">
        </form>
    </body>
</html>
