/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import conversores.ConversorDiaSemana;
import daos.DaoAtendenteServicoPostgres;
import entidades.Atendente;
import entidades.AtendenteServico;
import entidades.Atendimento;
import entidades.Cliente;
import entidades.Horario;
import entidades.Servico;
import enums.DiaSemana;
import fabricas.DaoFabricaBDPostgres;
import interfaces.Comando;
import interfaces.DaoAtendenteServicoInterface;
import interfaces.DaoAtendimentoInterface;
import interfaces.DaoHorarioInterface;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mathe
 */
public class HoraClienteController implements Comando{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        DaoFabricaBDPostgres daoFabricaBDPostgres = new DaoFabricaBDPostgres();
        DaoHorarioInterface daoHorario = daoFabricaBDPostgres.criarHorarioDao();
        DaoAtendenteServicoInterface daoAtendenteServico = daoFabricaBDPostgres.criarAtendenteServicoDao();
        DaoAtendimentoInterface daoAtendimento = daoFabricaBDPostgres.criarAtendimentoDao();
        
        HttpSession session = request.getSession();
        session.setAttribute("data", request.getParameter("data"));
        LocalDate data = LocalDate.parse((CharSequence) session.getAttribute("data"));
        DiaSemana dia = new ConversorDiaSemana().valueOf(data.getDayOfWeek().getValue());
        AtendenteServico atendenteServico = daoAtendenteServico.read((String) session.getAttribute("atendente"), (int) session.getAttribute("servico"));
        List<Atendimento> atendimentos = daoAtendimento.listAtendimentos((String) session.getAttribute("atendente"));
        
        List<Horario> horarios = daoHorario.list((String) session.getAttribute("atendente"));
        Horario horario = null;
        for(Horario h : horarios){
            if(h.getDiaSemana().equals(dia)){
                horario = h;
            }
        }
        List<LocalTime> hr = new ArrayList<>();
        if(horario != null){
            LocalTime ponteiro = horario.getInicio();
            hr.add(ponteiro);
            while(ponteiro.isBefore(horario.getFim())){
                ponteiro = ponteiro.plusMinutes(atendenteServico.getTempo());
                hr.add(ponteiro);
            }
            
        }
        List<Atendimento> atDoDia = new ArrayList<>();
        for(Atendimento a : atendimentos){
            if(a.getDia().equals(data)){
                atDoDia.add(a);
            }
        } 
        List<LocalTime> horariosDisponiveis = new ArrayList<>();
        for(LocalTime h : hr){
            int cont = 0;
            for(Atendimento a : atDoDia){
                if(!a.getHora().equals(h)) cont +=1;
            }
            if(cont == atDoDia.size()){
                horariosDisponiveis.add(h);
            }
        }
        request.setAttribute("horarios", horariosDisponiveis);
        request.getRequestDispatcher("horacliente.jsp").forward(request, response);
    }
    
}
