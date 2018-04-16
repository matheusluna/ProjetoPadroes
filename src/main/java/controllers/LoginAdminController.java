/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entidades.Admin;
import fabricas.DaoFabricaBDPostgres;
import interfaces.Comando;
import interfaces.DaoAdminInterface;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mathe
 */
public class LoginAdminController implements Comando{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        DaoFabricaBDPostgres daoFabricaBDPostgres = new DaoFabricaBDPostgres();
        DaoAdminInterface daoAdmin = daoFabricaBDPostgres.criarAdminDao();
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        Admin admin = daoAdmin.read(email);
        
        if(admin != null){
            if(admin.getSenha().equals(senha)){
                request.getRequestDispatcher("principalAdmin.jsp").forward(request, response);
            }
        }
    }
    
}
