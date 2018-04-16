/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entidades.Horario;
import entidades.Servico;
import fabricas.DaoFabricaBDPostgres;
import interfaces.Comando;
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
public class CadastroServicoController implements Comando{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        DaoFabricaBDPostgres daoFabricaBDPostgres = new DaoFabricaBDPostgres();
        DaoServicoInterface daoServico = daoFabricaBDPostgres.criarServicoDao();
        
        String nome = request.getParameter("nome");
        double preco = Double.parseDouble(request.getParameter("preco"));
        Servico servico = new Servico(0, nome, preco);
        if(daoServico.create(servico)){
            request.getRequestDispatcher("principalAdmin.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("cadastroServico.jsp").forward(request, response);
        }
    }
    
}
