/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entidades.Atendente;
import fabricas.DaoFabricaBDPostgres;
import interfaces.Comando;
import interfaces.DaoAtendenteInterface;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mathe
 */
public class AtendentesController implements Comando{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        DaoFabricaBDPostgres daoFabricaBDPostgres = new DaoFabricaBDPostgres();
        DaoAtendenteInterface daoAtendente = daoFabricaBDPostgres.criarAtendenteDao();
        
        List<Atendente> atendentes = daoAtendente.list();
        request.setAttribute("atendentes", atendentes);
        request.getRequestDispatcher("atendentes.jsp").forward(request, response);
    }
    
}
