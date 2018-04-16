/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import conversores.ConversorDiaSemana;
import entidades.Atendente;
import entidades.Horario;
import enums.DiaSemana;
import fabricas.DaoFabricaBDPostgres;
import interfaces.Comando;
import interfaces.DaoAtendenteInterface;
import interfaces.DaoHorarioInterface;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mathe
 */
public class CadastroHorarioController implements Comando{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        DaoFabricaBDPostgres daoFabricaBDPostgres = new DaoFabricaBDPostgres();
        DaoHorarioInterface daoHorario = daoFabricaBDPostgres.criarHorarioDao();
        DaoAtendenteInterface daoAtendente = daoFabricaBDPostgres.criarAtendenteDao();
        Atendente atendente = daoAtendente.read(request.getParameter("email"));
        String horaInicio = request.getParameter("horainicio");
        String horaFim = request.getParameter("horafim");
        String dia = request.getParameter("diasemena");
        
        LocalTime inicio = LocalTime.parse(horaInicio);
        LocalTime fim = LocalTime.parse(horaFim);
        DiaSemana diaSemana = new ConversorDiaSemana().valueOf(dia);
        
        Horario horario = new Horario(atendente, inicio, fim, diaSemana);
        
        if(daoHorario.create(horario)){
            request.getRequestDispatcher("principalAdmin.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("cadastroHorario.jsp").forward(request, response);
        }
    }
    
}
