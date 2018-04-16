/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Atendente;
import fabricas.ConnectionFactory;
import interfaces.DaoAtendenteInterface;
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
public class DaoAtendentePostgres implements DaoAtendenteInterface{

    @Override
    public boolean create(Atendente atendente) {
        Atendente at = read(atendente.getEmail());
        if(at == null){
            try {
                Connection connection = new ConnectionFactory().getConnection();
                String sql = "insert into atendente values(?,?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, atendente.getNome());
                stmt.setString(2, atendente.getEmail());
                stmt.setString(3, atendente.getSenha());
                stmt.setString(4, atendente.getFoto());
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
    public Atendente read(String email) {
        try {
            Connection connection = new ConnectionFactory().getConnection();
            String sql = "select * from atendente where email = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            Atendente atendente = null;
            while(rs.next()){
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                String foto = rs.getString("foto");
                atendente = new Atendente(nome, email, senha, foto);
            }
            stmt.close();
            connection.close();
            return atendente;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
        
    }

    @Override
    public boolean update(Atendente atendente) {
        Atendente at = read(atendente.getEmail());
        if(at != null){
            try {
                Connection connection = new ConnectionFactory().getConnection();
                String sql = "update atendente set nome = ?, senha = ?, foto = ? where email = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, atendente.getNome());
                stmt.setString(2, atendente.getSenha());
                stmt.setString(3, atendente.getFoto());
                stmt.setString(4, atendente.getEmail());
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
    public boolean delete(Atendente atendente) {
        Atendente at = read(atendente.getEmail());
        if(at != null){
            try {
                Connection connection = new ConnectionFactory().getConnection();
                String sql = "delete from atendente where email = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, atendente.getEmail());
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
    public List<Atendente> list() {
        List<Atendente> atendentes = new ArrayList<>();
        try {
            Connection connection = new ConnectionFactory().getConnection();
            String sql = "select * from atendente";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {                
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                String foto = rs.getString("foto");
                Atendente atendente = new Atendente(nome, email, senha, foto);
                atendentes.add(atendente);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            return atendentes;
        }
        return atendentes;
    }
    
}
