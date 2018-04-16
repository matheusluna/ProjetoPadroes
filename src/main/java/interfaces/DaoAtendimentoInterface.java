/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Atendimento;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author mathe
 */
public interface DaoAtendimentoInterface {
    public boolean create(Atendimento atendimento);
    public Atendimento read(String cliente, String atendente, LocalDate dia, LocalTime hora);
    public boolean update(Atendimento atendimento);
    public boolean delete(Atendimento atendimento);
    public List<Atendimento> listAtendimentos(String atendente);
    public List<Atendimento> listDia(LocalDate dia);
}
