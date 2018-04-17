/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Admin;

/**
 *
 * @author mathe
 */
public interface DaoAdminInterface {
    public Admin read(String email);
}
