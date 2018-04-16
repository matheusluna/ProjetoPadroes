/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import conversores.ConversorDiaSemana;
import entidades.Atendente;
import entidades.Horario;
import enums.DiaSemana;
import fabricas.ConnectionFactory;
import fabricas.DaoFabricaBDPostgres;
import interfaces.DaoAtendenteInterface;
import interfaces.DaoHorarioInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathe
 */
public class DaoHorarioPostgres implements DaoHorarioInterface{

    @Override
    public boolean create(Horario horario) {
        Horario h = read(horario.getAtendente().getEmail(), horario.getInicio(), horario.getDiaSemana());
        if(h == null){
            try {
                Connection connection = new ConnectionFactory().getConnection();
                String sql = "insert into horarioatendente values(?,?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, horario.getAtendente().getEmail());
                stmt.setTime(2, Time.valueOf(horario.getInicio()));
                stmt.setTime(3, Time.valueOf(horario.getFim()));
                stmt.setString(4, horario.getDiaSemana().toString());
                boolean resultado = !stmt.execute();
                stmt.close();
                connection.close();
                return resultado;
            } catch (ClassNotFoundException | SQLException ex) {
                return false;
            }
            
        }
        return false;
    }

    @Override
    public Horario read(String atendente, LocalTime inicio, DiaSemana diasemana) {
        DaoFabricaBDPostgres daoFabricaBDPostgres = new DaoFabricaBDPostgres();
        DaoAtendenteInterface daoAtendente = daoFabricaBDPostgres.criarAtendenteDao();
        Horario horario = null;
        try {
            Connection connection = new ConnectionFactory().getConnection();
            String sql = "select * from horarioatendente where atendente = ? and inicio = ? and diasemana = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, atendente);
            stmt.setTime(2, Time.valueOf(inicio));
            stmt.setString(3, diasemana.toString());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Atendente a = daoAtendente.read(atendente);
                LocalTime fim = rs.getTime("fim").toLocalTime();
                horario = new Horario(a, inicio, fim, diasemana);
            }
            stmt.close();
            connection.close();
            return horario;
        } catch (ClassNotFoundException | SQLException ex) {
            return horario;
        }
        
    }

    @Override
    public boolean update(Horario horario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Horario horario) {
        Horario h = read(horario.getAtendente().getEmail(), horario.getInicio(), horario.getDiaSemana());
        if(h != null){
            try {
                Connection connection = new ConnectionFactory().getConnection();
                String sql = "delete from horarioatendente where atendente = ? and inicio = ? and diasemana = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, horario.getAtendente().getEmail());
                stmt.setTime(2, Time.valueOf(horario.getInicio()));
                stmt.setString(3, horario.getDiaSemana().toString());
                boolean resultado = !stmt.execute();
                stmt.close();
                connection.close();
                return resultado;
            } catch (ClassNotFoundException | SQLException ex) {
                return false;
            }
            
        }
        return false;
    }

    @Override
    public List<Horario> list(String atendente) {
        DaoFabricaBDPostgres daoFabricaBDPostgres = new DaoFabricaBDPostgres();
        DaoAtendenteInterface daoAtendente = daoFabricaBDPostgres.criarAtendenteDao();
        List<Horario> horarios = new ArrayList<>();
        try {
            Connection connection = new ConnectionFactory().getConnection();
            String sql = "select * from horarioatendente where atendente = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, atendente);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Atendente a = daoAtendente.read(atendente);
                LocalTime inicio = rs.getTime("inicio").toLocalTime();
                LocalTime fim = rs.getTime("fim").toLocalTime();
                DiaSemana diasemana = new ConversorDiaSemana().valueOf(rs.getString("diasemana"));
                Horario horario = new Horario(a, inicio, fim, diasemana);
                horarios.add(horario);
            }
            stmt.close();
            connection.close();
            return horarios;
        } catch (ClassNotFoundException |SQLException ex) {
            return horarios;
        }
        
    }
    
}
