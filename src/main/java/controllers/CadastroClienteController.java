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

/**
 *
 * @author mathe
 */
public class CadastroClienteController implements Comando{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        //recebendo dados da página cadastroCliente.jsp
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        //instanciando um cliente
        Cliente cliente = new Cliente(nome, sobrenome, email, senha);
        //instanciando daoas e frábrica
        DaoFabrica daoFabrica = new DaoFabricaPostgres();
        DaoClienteInterface daoCliente = daoFabrica.criarDaoCliente();
        if(daoCliente.create(cliente)){
            request.setAttribute("mensagem", "<div class='row green center-align'><span class='white-text'>Usuário cadastrado com sucesso!</span></div>");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
            request.setAttribute("mensagem", "<div class='row red center-align'><span class='white-text'>E-mail já cadastrado!</span></div>");
            request.getRequestDispatcher("cadastroCliente.jsp").forward(request, response);
        }
        
    }
    
}
