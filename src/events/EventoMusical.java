/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import java.util.Calendar;

/**
 *
 * @author hnleo
 */
public class EventoMusical extends Eventos {

    public EventoMusical(int codigoEvento, String tituloEvento, String descripcionEvento, Calendar fechaARealizar, double montoRenta) {
        super(codigoEvento, tituloEvento, descripcionEvento, fechaARealizar, montoRenta);
    }

    @Override
    String getTipoEvento() {
        return "MUSICAL";
    }

    @Override
    double calcularMonto() {
        return 0;
    }
    
    public enum TipoMusica{
        POP, ROCK, RAP, CLASICA, REGGEATON, OTRO
    }

}
