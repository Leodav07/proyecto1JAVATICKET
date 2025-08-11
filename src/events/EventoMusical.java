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
  private String tipoMusica;
    public EventoMusical(int codigoEvento, String tituloEvento, String descripcionEvento, Calendar fechaARealizar, double montoRenta, String tipoMusica) {
        super(codigoEvento, tituloEvento, descripcionEvento, fechaARealizar, montoRenta);
    }

    @Override
    String getTipoEvento() {
        return "MUSICAL";
    }

    @Override
    public double getMontoRenta(){
       double seguroDeGrama = montoRenta * 0.3;
       return montoRenta + seguroDeGrama;
   }
    
    
    public enum TipoMusica{
        POP, ROCK, RAP, CLASICA, REGGEATON, OTRO
    }

}
