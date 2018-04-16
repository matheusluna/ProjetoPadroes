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
    
    public DiaSemana valueOf(int diaSemanaInt){
        switch(diaSemanaInt){
            case 1:
                return DiaSemana.DOMINGO;
            case 2:
                return DiaSemana.SEGUNDA;
            case 3:
                return DiaSemana.TERÇA;
            case 4:
                return DiaSemana.QUARTA;
            case 5:
                return DiaSemana.QUINTA;
            case 6:
                return DiaSemana.SEXTA;
            case 7:
                return DiaSemana.SÁBADO;
            
        }
        return DiaSemana.DOMINGO;
    }
}
