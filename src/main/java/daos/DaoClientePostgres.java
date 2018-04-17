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
        if(c == null){
            try {
                Connection connection = new ConnectionFactory().getConnection();
                String sql = "insert into cliente values(?,?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getSobrenome());
                stmt.setString(3, cliente.getEmail());
                stmt.setString(4, cliente.getSenha());
                boolean resultado = !stmt.execute();
                stmt.close();
                connection.close();
            } catch (ClassNotFoundException | SQLException ex) {
                return false;
            }
        }
        return false;
    }

    @Override
    public Cliente read(String email) {
        Cliente cliente = null;
        try {
            Connection connection = new ConnectionFactory().getConnection();
            String sql = "select * from cliente where email = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while(rs.next() && cliente == null){
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String senha = rs.getString("senha");
                cliente = new Cliente(nome, sobrenome, email, senha);
            }
            return cliente;
        } catch (ClassNotFoundException | SQLException ex) {
            return cliente;
        }
    }
    
}
