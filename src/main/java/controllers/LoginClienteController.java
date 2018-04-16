/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DaoClientePostgres;
import entidades.Cliente;
import fabricas.DaoFabricaBDPostgres;
import interfaces.Comando;
import interfaces.DaoClienteInterface;
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
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        DaoFabricaBDPostgres daoFabricaBDPostgres = new DaoFabricaBDPostgres();
        DaoClienteInterface daoCliente = new DaoClientePostgres();
        Cliente cliente = daoCliente.read(email);
        if(cliente != null){
            if(cliente.validaSenha(senha)){
                HttpSession session = request.getSession();
                session.setAttribute("usuario", cliente);
                request.getRequestDispatcher("principal.jsp").forward(request, response);
            }
        }
    }
    
}
