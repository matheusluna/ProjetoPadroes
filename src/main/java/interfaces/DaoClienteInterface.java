/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Cliente;

/**
 *
 * @author mathe
 */
public interface DaoClienteInterface {
    public boolean create(Cliente cliente);
    public Cliente read(String email);
}
