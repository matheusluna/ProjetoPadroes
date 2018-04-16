/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Atendente;
import entidades.AtendenteServico;
import entidades.Servico;
import java.util.List;

/**
 *
 * @author mathe
 */
public interface DaoAtendenteServicoInterface {
    public boolean create(AtendenteServico atendenteServico);
    public AtendenteServico read(String atendente,int servico);
    public boolean update(AtendenteServico atendenteServico);
    public boolean delete(AtendenteServico atendenteServico);
    public List<Servico> listServicos(String atendente);
    public List<Atendente> listAtendetes(int servico);
}
