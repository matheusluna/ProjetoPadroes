/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Servico;
import fabricas.ConnectionFactory;
import interfaces.DaoServicoInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathe
 */
public class DaoServicoPostgres implements DaoServicoInterface{

    @Override
    public boolean create(Servico servico) {
        Servico s = read(servico.getId(), servico.getNome());
        if(s == null){
            try {
                Connection connection = new ConnectionFactory().getConnection();
                String sql = "insert into servico (nome, preco) values(?, ?)";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, servico.getNome());
                stmt.setDouble(2, servico.getPreco());
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
    public Servico read(int id, String nome) {
        Servico servico = null;
        try {
            Connection connection = new ConnectionFactory().getConnection();
            String sql = "select * from servico where id = ? or nome = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {                
                double preco = rs.getDouble("preco");
                servico = new Servico(id, nome, preco);
            }
            return servico;
            
        } catch (ClassNotFoundException | SQLException ex) {
            return servico;
        }
        
    }

    @Override
    public boolean update(Servico servico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Servico servico) {
        Servico s = read(servico.getId(), servico.getNome());
        if(s != null){
            try {
                Connection connection = new ConnectionFactory().getConnection();
                String sql = "delete from servico where id = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, servico.getId());
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
    public List<Servico> list() {
        List<Servico> servicos = new ArrayList<>();
        try {
            Connection connection = new ConnectionFactory().getConnection();
            String sql = "select * from servico";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {                
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                Servico servico = new Servico(id, nome, preco);
                servicos.add(servico);
            }
            return servicos;
        } catch (ClassNotFoundException | SQLException ex) {
            return servicos;
        }
        
    }
    
}
