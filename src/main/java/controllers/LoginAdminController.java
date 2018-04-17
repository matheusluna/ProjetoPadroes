/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DaoAdminPostgres;
import entidades.Admin;
import fabricas.DaoFabricaPostgres;
import interfaces.Comando;
import interfaces.DaoAdminInterface;
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
public class LoginAdminController implements Comando{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        DaoFabrica daoFabrica = new DaoFabricaPostgres();
        DaoAdminInterface daoAdmin = new DaoAdminPostgres();
        
        Admin admin = daoAdmin.read(email);
        if(admin != null){
            if(admin.getSenha().equals(senha)){
                HttpSession session = request.getSession();
                session.setAttribute("admin", admin);
                request.getRequestDispatcher("principalAdmin.jsp").forward(request, response);
            }else{
                request.setAttribute("mensagem", "<div class='row red center-align'><span class='white-text'>Senha incorreta!</span></div>");
                request.getRequestDispatcher("loginAdmin.jsp").forward(request, response);
            }
            
        }else{
            request.setAttribute("mensagem", "<div class='row red center-align'><span class='white-text'>E-mail não cadastrado!</span></div>");
            request.getRequestDispatcher("loginAdmin.jsp").forward(request, response);
        }
    }
    
}
