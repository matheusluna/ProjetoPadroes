<%--
    Document   : cadastroCliente
    Created on : 17/04/2018, 15:15:47
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav>
          <div class="nav-wrapper teal darken-4">
            <a href="index.jsp" class="brand-logo"><i class="large material-icons">arrow_back</i>Cadastro</a>
          </div>
        </nav>
        ${mensagem}
        <div class="container">
          <form action="Frontal" method="post">
            <div class="row">
              <div class="input-field col s6">
                <input type="text" name="nome" id="nome" value="">
                <label for="nome">Nome</label>
              </div>
              <div class="input-field col s6">
                <input type="text" name="sobrenome" id="sobrenome" value="">
                <label for="sobrenome">Sobrenome</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <input type="email" name="email" id="email" value="">
                <label for="email">E-mail</label>
              </div>
              <div class="input-field col s6">
                <input type="password" name="senha" id="senha" value="">
                <label for="senha">Senha</label>
              </div>
            </div>
            <div class="row center-align">
              <input type="hidden" name="caminho" value="CadastroCliente">
              <input class="btn" type="submit" name="" value="CADASTRAR">
            </div>
          </form>
        </div>
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
    </body>
</html>
