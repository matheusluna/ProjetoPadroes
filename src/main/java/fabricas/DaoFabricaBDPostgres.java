/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricas;

import daos.DaoAdminPostgres;
import daos.DaoAtendentePostgres;
import daos.DaoAtendenteServicoPostgres;
import daos.DaoAtendimentoPostgres;
import daos.DaoClientePostgres;
import daos.DaoHorarioPostgres;
import daos.DaoServicoPostgres;
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
        return new DaoAtendentePostgres();
    }

    @Override
    public DaoAtendenteServicoInterface criarAtendenteServicoDao() {
        return new DaoAtendenteServicoPostgres();
    }

    @Override
    public DaoAtendimentoInterface criarAtendimentoDao() {
        return new DaoAtendimentoPostgres();
    }

    @Override
    public DaoHorarioInterface criarHorarioDao() {
        return new DaoHorarioPostgres();
    }

    @Override
    public DaoServicoInterface criarServicoDao() {
        return new DaoServicoPostgres();
    }
    
}
