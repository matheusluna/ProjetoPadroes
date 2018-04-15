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
public interface DaoFabricaBanco {
    public DaoClienteInterface criaClienteDao();
    public DaoAdminInterface criarAdminDao();
    public DaoAtendenteInterface criarAtendenteDao();
    public DaoAtendenteServicoInterface criarAtendenteServicoDao();
    public DaoAtendimentoInterface criarAtendimentoDao();
    public DaoHorarioInterface criarHorarioDao();
    public DaoServicoInterface criarServicoDao();
}
