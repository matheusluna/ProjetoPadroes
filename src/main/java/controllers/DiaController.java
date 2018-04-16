/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import fabricas.DaoFabricaBDPostgres;
import interfaces.Comando;
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
public class DiaController implements Comando{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        HttpSession session = request.getSession();
        int servico = Integer.parseInt(request.getParameter("servico"));
        session.setAttribute("servico", servico);
        request.getRequestDispatcher("dia.jsp").forward(request, response);
    }
    
}
