/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Admin;
import fabricas.ConnectionFactory;
import interfaces.DaoAdminInterface;
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
public class DaoAdminPostgres implements DaoAdminInterface{

    @Override
    public Admin read(String email) {
        Admin admin = null;
        try {
            Connection connection = new ConnectionFactory().getConnection();
            String sql = "select * from admin where email = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while(rs.next() && admin == null){
                String senha = rs.getString("senha");
                admin = new Admin(email, senha);
            }
            
            return admin;
        } catch (ClassNotFoundException | SQLException ex) {
            return admin;
        }
    }
    
}
