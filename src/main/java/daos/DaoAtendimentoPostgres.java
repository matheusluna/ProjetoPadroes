/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Atendente;
import entidades.Atendimento;
import entidades.Cliente;
import entidades.Servico;
import fabricas.ConnectionFactory;
import fabricas.DaoFabricaBDPostgres;
import interfaces.DaoAtendenteInterface;
import interfaces.DaoAtendimentoInterface;
import interfaces.DaoClienteInterface;
import interfaces.DaoServicoInterface;
import java.sql.Connection;
import java.sql.Date;
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
public class DaoAtendimentoPostgres implements DaoAtendimentoInterface{

    @Override
    public boolean create(Atendimento atendimento) {
        Atendimento a = read(atendimento.getCliente().getEmail(), atendimento.getAtendente().getEmail(), 
                atendimento.getDia(), 
                atendimento.getHora());
        if(a == null){
            try {
                Connection connection = new ConnectionFactory().getConnection();
                String sql = "insert into atendimento values(?,?,?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, atendimento.getCliente().getEmail());
                stmt.setString(2, atendimento.getAtendente().getEmail());
                stmt.setInt(3, atendimento.getServico().getId());
                stmt.setDate(4, Date.valueOf(atendimento.getDia()));
                stmt.setTime(5, Time.valueOf(atendimento.getHora()));
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
    public Atendimento read(String cliente, String atendente, LocalDate dia, LocalTime hora) {
        DaoAtendenteInterface daoAtendente = new DaoFabricaBDPostgres().criarAtendenteDao();
        DaoClienteInterface daoCliente = new DaoFabricaBDPostgres().criaClienteDao();
        DaoServicoInterface daoServico = new DaoFabricaBDPostgres().criarServicoDao();
        Atendimento atendimento = null;
        try {
            Connection connection = new ConnectionFactory().getConnection();
            String sql = "select * from atendimento where cliente = ? and atendente = ? and dia = ? and inicio = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente);
            stmt.setString(2, atendente);
            stmt.setDate(3, Date.valueOf(dia));
            stmt.setTime(4, Time.valueOf(hora));
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Cliente c = daoCliente.read(cliente);
                Atendente a = daoAtendente.read(atendente);
                Servico s = daoServico.read(rs.getInt("id"));
                atendimento = new Atendimento(c, a, s, dia, hora);                
            }
            stmt.close();
            connection.close();
            return atendimento;
        } catch (ClassNotFoundException | SQLException ex) {
            return atendimento;
        }
    }

    @Override
    public boolean update(Atendimento atendimento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Atendimento atendimento) {
         Atendimento a = read(atendimento.getCliente().getEmail(), atendimento.getAtendente().getEmail(), 
                atendimento.getDia(), 
                atendimento.getHora());
        if(a != null){
            try {
                Connection connection = new ConnectionFactory().getConnection();
                String sql = "delete from atendimento where cliente = ? and atendente = ? and servico = ? and dia = ? and inicio = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, atendimento.getCliente().getEmail());
                stmt.setString(2, atendimento.getAtendente().getEmail());
                stmt.setInt(3, atendimento.getServico().getId());
                stmt.setDate(4, Date.valueOf(atendimento.getDia()));
                stmt.setTime(5, Time.valueOf(atendimento.getHora()));
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
    public List<Atendimento> listAtendimentos(String atendente) {
        DaoAtendenteInterface daoAtendente = new DaoFabricaBDPostgres().criarAtendenteDao();
        DaoClienteInterface daoCliente = new DaoFabricaBDPostgres().criaClienteDao();
        DaoServicoInterface daoServico = new DaoFabricaBDPostgres().criarServicoDao();
        List<Atendimento> atendimentos = new ArrayList<>();
        try {
            Connection connection = new ConnectionFactory().getConnection();
            String sql = "select * from atendimento where atendente = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, atendente);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Cliente c = daoCliente.read(rs.getString("cliente"));
                Atendente a = daoAtendente.read(atendente);
                Servico s = daoServico.read(rs.getInt("id"));
                LocalDate dia = rs.getDate("dia").toLocalDate();
                LocalTime hora = rs.getTime("inicio").toLocalTime();
                Atendimento atendimento = new Atendimento(c, a, s, dia, hora);
                atendimentos.add(atendimento);
                
            }
            stmt.close();
            connection.close();
            return atendimentos;
            
        } catch (ClassNotFoundException |SQLException ex) {
            return atendimentos;
        }
        
        
    }

    @Override
    public List<Atendimento> listDia(LocalDate dia) {
        DaoAtendenteInterface daoAtendente = new DaoFabricaBDPostgres().criarAtendenteDao();
        DaoClienteInterface daoCliente = new DaoFabricaBDPostgres().criaClienteDao();
        DaoServicoInterface daoServico = new DaoFabricaBDPostgres().criarServicoDao();
        List<Atendimento> atendimentos = new ArrayList<>();
        try {
            Connection connection = new ConnectionFactory().getConnection();
            String sql = "select * from atendimento where dia = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, Date.valueOf(dia));
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Cliente c = daoCliente.read(rs.getString("cliente"));
                Atendente a = daoAtendente.read(rs.getString("atendente"));
                Servico s = daoServico.read(rs.getInt("id"));
                LocalTime hora = rs.getTime("inicio").toLocalTime();
                Atendimento atendimento = new Atendimento(c, a, s, dia, hora);
                atendimentos.add(atendimento);
                
            }
            stmt.close();
            connection.close();
            return atendimentos;
            
        } catch (ClassNotFoundException |SQLException ex) {
            return atendimentos;
        }
    }
    
}
