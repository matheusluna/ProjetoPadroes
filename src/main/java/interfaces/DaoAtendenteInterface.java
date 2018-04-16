/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Atendente;
import java.util.List;

/**
 *
 * @author mathe
 */
public interface DaoAtendenteInterface {
    public boolean create(Atendente atendente);
    public Atendente read(String email);
    public boolean update(Atendente atendente);
    public boolean delete(Atendente atendente);
    public List<Atendente> list();
}
