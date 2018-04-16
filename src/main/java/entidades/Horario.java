/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import enums.DiaSemana;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author mathe
 */
public class Horario {
    private Atendente atendente;
    private LocalTime inicio;
    private LocalTime fim;
    private DiaSemana diaSemana;

    public Horario() {
    }

    public Horario(Atendente atendente, LocalTime inicio, LocalTime fim, DiaSemana diaSemana) {
        this.atendente = atendente;
        this.inicio = inicio;
        this.fim = fim;
        this.diaSemana = diaSemana;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalTime inicio) {
        this.inicio = inicio;
    }

    public LocalTime getFim() {
        return fim;
    }

    public void setFim(LocalTime fim) {
        this.fim = fim;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.atendente);
        hash = 29 * hash + Objects.hashCode(this.inicio);
        hash = 29 * hash + Objects.hashCode(this.fim);
        hash = 29 * hash + Objects.hashCode(this.diaSemana);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Horario other = (Horario) obj;
        if (!Objects.equals(this.atendente, other.atendente)) {
            return false;
        }
        if (!Objects.equals(this.inicio, other.inicio)) {
            return false;
        }
        if (!Objects.equals(this.fim, other.fim)) {
            return false;
        }
        if (this.diaSemana != other.diaSemana) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Horario{" + "atendente=" + atendente + ", inicio=" + inicio + ", fim=" + fim + ", diaSemana=" + diaSemana + '}';
    }
    
}
