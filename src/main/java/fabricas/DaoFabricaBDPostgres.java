/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricas;

import daos.DaoAdminPostgres;
import daos.DaoClientePostgres;
import interfaces.DaoAdminInterface;
import interfaces.DaoAtendenteInterface;
import interfaces.DaoAtendenteServicoInterface;
import interfaces.DaoAtendimentoInterface;
import interfaces.DaoClienteInterface;
import interfaces.DaoFabricaBanco;
import interfaces.DaoHorarioInterface;
import interfaces.DaoServicoInterface;

/**
 *
 * @author mathe
 */
public class DaoFabricaBDPostgres implements DaoFabricaBanco{

    @Override
    public DaoClienteInterface criaClienteDao() {
        return new DaoClientePostgres();
    }

    @Override
    public DaoAdminInterface criarAdminDao() {
        return new DaoAdminPostgres();
    }

    @Override
    public DaoAtendenteInterface criarAtendenteDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DaoAtendenteServicoInterface criarAtendenteServicoDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DaoAtendimentoInterface criarAtendimentoDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DaoHorarioInterface criarHorarioDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DaoServicoInterface criarServicoDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
