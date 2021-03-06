/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entidades.Cliente;
import fabricas.DaoFabricaPostgres;
import interfaces.Comando;
import interfaces.DaoClienteInterface;
import interfaces.DaoFabrica;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mathe
 */
public class LoginClienteController implements Comando{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        //Recebendo dados da página index.jsp
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        //Instanciando fábrica de daos
        DaoFabrica daoFabrica = new DaoFabricaPostgres();
        //instanciando o dao do cliente
        DaoClienteInterface daoCliente = daoFabrica.criarDaoCliente();
        //Procurando dados do cliente no banco de dados
        Cliente cliente = daoCliente.read(email);
        if(cliente != null){
            if(cliente.getSenha().equals(senha)){
                HttpSession session = request.getSession();
                session.setAttribute("usuario", cliente);
                request.getRequestDispatcher("principalCliente.jsp").forward(request, response);
            }else{
                request.setAttribute("mensagem", "<div class='row red center-align'><span class='white-text'>Senha incorreta!</span></div>");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("mensagem", "<div class='row red center-align'><span class='white-text'>E-mail não cadastrado!</span></div>");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    
}
