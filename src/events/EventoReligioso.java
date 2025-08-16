/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author hnleo
 */
public class EventoReligioso extends Eventos {
    private ArrayList<String> personasConvertidas;
 

    public EventoReligioso(int codigoEvento, String tituloEvento, String descripcionEvento, Calendar fechaARealizar, double montoRenta, int cantidadPersonas) {
        super(codigoEvento, tituloEvento, descripcionEvento, fechaARealizar, montoRenta, cantidadPersonas);
       personasConvertidas = new ArrayList<>();
    }

    @Override
    String getTipoEvento() {
        return "RELIGIOSO";
    }
    @Override
    public String getCancelado(){
        return super.getCancelado();
    }
   @Override
   public double getMontoRenta(){
       return montoRenta + 2000;
   }

    public ArrayList<String> getPersonasConvertidas() {
        return personasConvertidas;
    }

    public void setPersonasConvertidas(ArrayList<String> personasConvertidas) {
        this.personasConvertidas = personasConvertidas;
    }
    
    

}
