/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entidades.Atendente;
import entidades.AtendenteServico;
import entidades.Servico;
import fabricas.DaoFabricaBDPostgres;
import interfaces.Comando;
import interfaces.DaoAtendenteInterface;
import interfaces.DaoAtendenteServicoInterface;
import interfaces.DaoServicoInterface;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mathe
 */
public class CadastroAtendenteServicoController implements Comando{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        DaoFabricaBDPostgres daoFabricaBDPostgres = new DaoFabricaBDPostgres();
        DaoAtendenteInterface daoAtendente = daoFabricaBDPostgres.criarAtendenteDao();
        DaoServicoInterface daoServico = daoFabricaBDPostgres.criarServicoDao();
        DaoAtendenteServicoInterface daoAtendenteServico = daoFabricaBDPostgres.criarAtendenteServicoDao();
        
        Atendente atendente = daoAtendente.read(request.getParameter("atendente"));
        Servico servico = daoServico.read(Integer.parseInt(request.getParameter("servicoa")), "");
        int tempo = Integer.valueOf(request.getParameter("tempo"));
        
        AtendenteServico atendenteServico = new AtendenteServico(atendente, servico, tempo);
        
        if(daoAtendenteServico.create(atendenteServico)){
            request.getRequestDispatcher("principalAdmin.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("cadastroAtendenteServico.jsp").forward(request, response);
        }
        
    }
    
}
