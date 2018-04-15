/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mathe
 */
public class ConnectionFactory {
    private String drive = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://localhost:5432/projetopadroes";
    private String user = "postgres";
    private String senha = "123456";
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName(drive);
        return DriverManager.getConnection(url, user, senha);
    }
}
