/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author mathe
 */
public interface DaoFabrica {
    public DaoClienteInterface criarDaoCliente();
    public DaoAdminInterface criarDaoAdmin();
}
