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
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author mathe
 */
public class CadastroFuncionarioController implements Comando{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        DaoFabricaBDPostgres daoFabricaBDPostgres = new DaoFabricaBDPostgres();
        DaoAtendenteInterface daoAtendente = daoFabricaBDPostgres.criarAtendenteDao();
        
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        //foto
        String caminho = File.separator+request.getServletContext().getRealPath("img")+File.separator+email;
        File caminhoUser = new File(caminho);
        if(!caminhoUser.exists()) {
                caminhoUser.mkdirs();
        }
        Part path = request.getPart("foto");
        String cam = caminho+File.separator+path.getSubmittedFileName();
        path.write(cam);
        String foto = "img"+File.separator+email+File.separator+path.getSubmittedFileName();
        
        Atendente atendente = new Atendente(nome, email, senha, foto);
        if(daoAtendente.create(atendente)){
            request.getRequestDispatcher("principalAdmin.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("cadastroFuncionario.jsp").forward(request, response);
        }
    }
    
}
