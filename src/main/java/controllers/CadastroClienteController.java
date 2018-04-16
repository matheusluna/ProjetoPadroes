/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entidades.Cliente;
import fabricas.DaoFabricaBDPostgres;
import interfaces.Comando;
import interfaces.DaoClienteInterface;
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
        DaoFabricaBDPostgres daoFabricaBDPostgres = new DaoFabricaBDPostgres();
        DaoClienteInterface daoCliente = daoFabricaBDPostgres.criaClienteDao();
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        Cliente cliente = new Cliente(nome, sobrenome, email, senha);
        if(daoCliente.create(cliente)){
            request.setAttribute("mensagem", "<script>alert('Usuário cadastrado com sucesso')</script>");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
            request.setAttribute("mensagem", "<script>alert('Não foi possível cadastrar')</script>");
            request.getRequestDispatcher("cadastroCliente.jsp").forward(request, response);
        }
    }
    
}
