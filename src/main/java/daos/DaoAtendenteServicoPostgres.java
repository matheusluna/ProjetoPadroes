/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Atendente;
import entidades.AtendenteServico;
import entidades.Servico;
import fabricas.ConnectionFactory;
import fabricas.DaoFabricaBDPostgres;
import interfaces.DaoAtendenteInterface;
import interfaces.DaoAtendenteServicoInterface;
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
public class DaoAtendenteServicoPostgres implements DaoAtendenteServicoInterface{

    @Override
    public boolean create(AtendenteServico atendenteServico) {
        System.out.println(atendenteServico.getAtendente().getEmail());
        System.out.println(atendenteServico.getServico().getId());
        AtendenteServico as = read(atendenteServico.getAtendente().getEmail(), atendenteServico.getServico().getId());
        if(as == null){
            try {
                Connection connection = new ConnectionFactory().getConnection();
                String sql = "insert into atendenteservico values(?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, atendenteServico.getAtendente().getEmail());
                stmt.setInt(2, atendenteServico.getServico().getId());
                stmt.setInt(3, atendenteServico.getTempo());
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
    public AtendenteServico read(String atendente, int servico) {
        DaoFabricaBDPostgres daoFabricaBDPostgres = new DaoFabricaBDPostgres();
        DaoAtendenteInterface daoAtendente = daoFabricaBDPostgres.criarAtendenteDao();
        DaoServicoInterface daoServico = daoFabricaBDPostgres.criarServicoDao();
        AtendenteServico atendenteServico = null;
        try {
            Connection connection = new ConnectionFactory().getConnection();
            String sql = "select * from atendenteservico where atendente = ? and servico = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, atendente);
            stmt.setInt(2, servico);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {                
                Atendente a = daoAtendente.read(atendente);
                Servico s = daoServico.read(servico, "");
                int tempo = rs.getInt("tempo");
                atendenteServico = new AtendenteServico(a, s, tempo);
            }
            stmt.close();
            connection.close();
            return atendenteServico;
        } catch (ClassNotFoundException | SQLException ex) {
            return atendenteServico;
        }
    }

    @Override
    public boolean update(AtendenteServico atendenteServico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(AtendenteServico atendenteServico) {
        DaoFabricaBDPostgres daoFabricaBDPostgres = new DaoFabricaBDPostgres();
        DaoAtendenteInterface daoAtendente = daoFabricaBDPostgres.criarAtendenteDao();
        DaoServicoInterface daoServico = daoFabricaBDPostgres.criarServicoDao();
        AtendenteServico as = read(atendenteServico.getAtendente().getEmail(), atendenteServico.getServico().getId());
        if(as != null){
            try {
                Connection connection = new ConnectionFactory().getConnection();
                String sql = "delete from atendenteservico where atendente = ? and servico = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, atendenteServico.getAtendente().getEmail());
                stmt.setInt(1, atendenteServico.getServico().getId());
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
    public List<Servico> listServicos(String atendente) {
        DaoFabricaBDPostgres daoFabricaBDPostgres = new DaoFabricaBDPostgres();
        DaoServicoInterface daoServico = daoFabricaBDPostgres.criarServicoDao();
        List<Servico> servicos = new ArrayList<>();
        try {
            Connection connection = new ConnectionFactory().getConnection();
            String sql = "select servico from atendenteservico where atendente = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, atendente);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Servico servico = daoServico.read(rs.getInt("servico"), "");
                servicos.add(servico);
            }
            stmt.close();
            connection.close();
            return servicos;
        } catch (ClassNotFoundException | SQLException ex) {
            return servicos;
        }
    }

    @Override
    public List<Atendente> listAtendetes(int servico) {
        DaoFabricaBDPostgres daoFabricaBDPostgres = new DaoFabricaBDPostgres();
        DaoAtendenteInterface daoAtendente = daoFabricaBDPostgres.criarAtendenteDao();
        List<Atendente> atendentes = new ArrayList<>();
        try {
            Connection connection = new ConnectionFactory().getConnection();
            String sql = "select atendente from atendenteservico where servico = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, servico);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Atendente atendente = daoAtendente.read(rs.getString("atendente"));
                atendentes.add(atendente);
            }
            stmt.close();
            connection.close();
            return atendentes;
        } catch (ClassNotFoundException | SQLException ex) {
            return atendentes;
        }
    }
    
}
