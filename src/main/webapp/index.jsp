<%--
    Document   : index
    Created on : 17/04/2018, 10:20:34
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
        <title>BarberApp</title>
    </head>
    <body>
        ${mensagem}
        <div class="container">
          <div class="row center-align">
            <br><br>
            <img src="img/icone.png" width="100px" alt="">
            <h3 class="grey-text text-darken-2">BarberApp</h3>
          </div>
          <div class="container">
            <div class="container">
              <div class="container">
                <form action="Frontal" method="post">
                  <div class="row">
                    <div class="input-field col s12">
                      <input type="email" id="email" name="email" value="">
                      <label for="email">E-mail</label>
                    </div>
                  </div>
                  <div class="row">
                    <div class="input-field col s12">
                      <input type="password" id="senha" name="senha" value="">
                      <label for="senha">Senha</label>
                      <span>Não possui conta? <a href="cadastroCliente.jsp">Clique aqui</a></span><br>

                    </div>
                  </div>
                  <div class="row">
                    <div class="center-align">
                      <input type="hidden" name="caminho" value="LoginCliente">
                      <input class="btn" type="submit" name="" value="Login">
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
    </body>
</html>
