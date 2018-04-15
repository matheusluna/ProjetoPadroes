/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Cliente;
import fabricas.ConnectionFactory;
import interfaces.DaoClienteInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathe
 */
public class DaoClientePostgres implements DaoClienteInterface{

    @Override
    public boolean create(Cliente cliente) {
        Cliente c = read(cliente.getEmail());
        Connection connection;
        if(c == null){
            try {
                connection = new ConnectionFactory().getConnection();
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("não conectou");
                return false;
            }
            String sql = "insert into cliente values(?,?,?,?)";
            PreparedStatement stmt;
            try {
                stmt = connection.prepareStatement(sql);
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getSobrenome());
                stmt.setString(3, cliente.getEmail());
                stmt.setString(4, cliente.getSenha());
                boolean resultado = !stmt.execute();
                
                stmt.close();
                connection.close();
                return resultado;
            } catch (SQLException ex) {
                return false;
            }
        }
        return false;
    }

    @Override
    public Cliente read(String email) {
        Connection connection;
        try {
            connection = new ConnectionFactory().getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
        String sql = "select * from cliente where email = ?";
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            Cliente cliente = null;
            while (rs.next()) {            
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String emailbd = rs.getString("email");
                String senha = rs.getString("senha");
                cliente = new Cliente(nome, sobrenome, emailbd, senha);
            }
            return cliente;
        } catch (SQLException ex) {
            return null;
        }
        
    }

    @Override
    public boolean update(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
