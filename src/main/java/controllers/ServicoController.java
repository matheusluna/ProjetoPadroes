/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entidades.Servico;
import fabricas.DaoFabricaBDPostgres;
import interfaces.Comando;
import interfaces.DaoAtendenteServicoInterface;
import interfaces.DaoServicoInterface;
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
public class ServicoController implements Comando{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        DaoFabricaBDPostgres daoFabricaBDPostgres = new DaoFabricaBDPostgres();
        DaoServicoInterface daoServico = daoFabricaBDPostgres.criarServicoDao();

        List<Servico> servicos = daoServico.list();
        
        request.setAttribute("servicos", servicos);
        request.getRequestDispatcher("cadastroAtendenteServico.jsp").forward(request, response);
    }
    
}
