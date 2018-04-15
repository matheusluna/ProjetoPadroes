/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Objects;

/**
 *
 * @author mathe
 */
public class AtendenteServico {
    private Atendente atendente;
    private Servico servico;
    private int tempo;

    public AtendenteServico() {
    }

    public AtendenteServico(Atendente atendente, Servico servico, int tempo) {
        this.atendente = atendente;
        this.servico = servico;
        this.tempo = tempo;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.atendente);
        hash = 79 * hash + Objects.hashCode(this.servico);
        hash = 79 * hash + this.tempo;
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
        final AtendenteServico other = (AtendenteServico) obj;
        if (this.tempo != other.tempo) {
            return false;
        }
        if (!Objects.equals(this.atendente, other.atendente)) {
            return false;
        }
        if (!Objects.equals(this.servico, other.servico)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AtendenteServico{" + "atendente=" + atendente + ", servico=" + servico + ", tempo=" + tempo + '}';
    }
    
}
