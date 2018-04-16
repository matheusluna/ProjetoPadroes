/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DaoAtendenteServicoPostgres;
import entidades.Servico;
import fabricas.DaoFabricaBDPostgres;
import interfaces.Comando;
import interfaces.DaoAtendenteServicoInterface;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mathe
 */
public class ServicoAtendenteClienteController implements Comando{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        DaoFabricaBDPostgres daoFabricaBDPostgres = new DaoFabricaBDPostgres();
        DaoAtendenteServicoInterface daoAtendenteServico = daoFabricaBDPostgres.criarAtendenteServicoDao();
        
        String atendente = request.getParameter("email");
        System.out.println(atendente);
        List<Servico> servicos = daoAtendenteServico.listServicos(atendente);
        System.out.println(servicos.get(0).getNome());
        HttpSession session = request.getSession();
        session.setAttribute("atendente", atendente);
        request.setAttribute("servicos", servicos);
        request.getRequestDispatcher("servicoscliente.jsp").forward(request, response);
        
    }
    
}
