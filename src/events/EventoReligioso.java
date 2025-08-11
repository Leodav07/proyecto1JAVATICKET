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
public class EventoReligioso extends Eventos {

    public EventoReligioso(int codigoEvento, String tituloEvento, String descripcionEvento, Calendar fechaARealizar, double montoRenta) {
        super(codigoEvento, tituloEvento, descripcionEvento, fechaARealizar, montoRenta);
    }

    @Override
    String getTipoEvento() {
        return "RELIGIOSO";
    }

   @Override
   public double getMontoRenta(){
       return montoRenta + 2000;
   }
    
    

}
