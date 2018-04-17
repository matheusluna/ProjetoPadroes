/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricas;

import daos.DaoClientePostgres;
import interfaces.DaoAdminInterface;
import interfaces.DaoClienteInterface;
import interfaces.DaoFabrica;

/**
 *
 * @author mathe
 */
public class DaoFabricaPostgres implements DaoFabrica{

    @Override
    public DaoClienteInterface criarDaoCliente() {
        return  new DaoClientePostgres();
    }

    @Override
    public DaoAdminInterface criarDaoAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
