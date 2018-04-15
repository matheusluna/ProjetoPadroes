/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Horario;
import enums.DiaSemana;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author mathe
 */
public interface DaoHorarioInterface {
    public boolean create(Horario horario);
    public Horario read(String atendente, LocalDate dia, LocalDateTime inicio, DiaSemana diasemana);
    public boolean update(Horario horario);
    public boolean delete(Horario horario);
    public List<Horario> list(String atendente);
}
