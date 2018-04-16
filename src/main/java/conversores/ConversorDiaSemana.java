/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversores;

import enums.DiaSemana;

/**
 *
 * @author mathe
 */
public class ConversorDiaSemana {
    public DiaSemana valueOf(String diaSemanaStrirng){
        switch(diaSemanaStrirng){
            case "SEGUNDA":
                return DiaSemana.SEGUNDA;
            case "TERÇA":
                return DiaSemana.TERÇA;
            case "QUARTA":
                return DiaSemana.QUARTA;
            case "QUINTA":
                return DiaSemana.QUINTA;
            case "SEXTA":
                return DiaSemana.SEXTA;
            case "SÁBADO":
                return DiaSemana.SÁBADO;
            case "DOMINGO":
                return DiaSemana.DOMINGO;
        }
        return DiaSemana.DOMINGO;
    }
}
