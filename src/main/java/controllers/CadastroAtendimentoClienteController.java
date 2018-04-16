/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entidades.Atendente;
import entidades.Atendimento;
import entidades.Cliente;
import entidades.Servico;
import fabricas.DaoFabricaBDPostgres;
import interfaces.Comando;
import interfaces.DaoAtendenteInterface;
import interfaces.DaoAtendimentoInterface;
import interfaces.DaoClienteInterface;
import interfaces.DaoServicoInterface;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mathe
 */
public class CadastroAtendimentoClienteController implements Comando{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        DaoFabricaBDPostgres daoFabricaBDPostgres = new DaoFabricaBDPostgres();
        DaoAtendimentoInterface daoAtendimento = daoFabricaBDPostgres.criarAtendimentoDao();
        DaoAtendenteInterface daoAtendente = daoFabricaBDPostgres.criarAtendenteDao();
        DaoClienteInterface daoCliente = daoFabricaBDPostgres.criaClienteDao();
        DaoServicoInterface daoServico = daoFabricaBDPostgres.criarServicoDao();
        HttpSession session = request.getSession();
        Atendente atendente = daoAtendente.read((String) session.getAttribute("atendente"));
        Cliente cliente = (Cliente) session.getAttribute("usuario");
        Servico servico = daoServico.read((int) session.getAttribute("servico"), "");
        String data = (String) session.getAttribute("data");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(data);
        LocalTime hora = LocalTime.parse(request.getParameter("hora"));
        
        Atendimento atendimento = new Atendimento(cliente, atendente, servico, date, hora);
        if(daoAtendimento.create(atendimento)){
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        }else{
            request.setAttribute("mensagem", "<script>alert('Não foi possível cadastrar o atendimento, horário ocupado.')</script>");
            request.getRequestDispatcher("horacliente.jsp").forward(request, response);
        }
        
        
    }
    
}
