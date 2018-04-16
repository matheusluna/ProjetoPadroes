/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Atendimento;
import fabricas.ConnectionFactory;
import interfaces.DaoAtendenteInterface;
import interfaces.DaoAtendimentoInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Atendimento read(String cliente, String atendente, LocalDate dia, LocalDateTime hora) {
        DaoAtendenteInterface = 
        Atendimento atendimento = null;
        try {
            Connection connection = new ConnectionFactory().getConnection();
            String sql = "select * from atendimento where cliente = ?, atendente = ?, dia = ?, inicio = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente);
            stmt.setString(2, atendente);
            stmt.setDate(3, date);
            stmt.setTime(4, time);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoAtendimentoPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean update(Atendimento atendimento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Atendimento atendimento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Atendimento> listAtendimentos(String atendente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Atendimento> listDia(LocalDate dia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
