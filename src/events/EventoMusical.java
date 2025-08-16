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
public class EventoMusical extends Eventos {
  private String tipoMusica;
   private ArrayList<String> integrantes;
    public EventoMusical(int codigoEvento, String tituloEvento, String descripcionEvento, Calendar fechaARealizar, double montoRenta, String tipoMusica, int cantidadPersonas) {
        super(codigoEvento, tituloEvento, descripcionEvento, fechaARealizar, montoRenta, cantidadPersonas);
     integrantes = new ArrayList<>();
    }

    @Override
    public String getTipoEvento() {
        return "MUSICAL";
    }

    public String getTipoMusica() {
        return tipoMusica;
    }
    @Override
    public String getCancelado(){
        return super.getCancelado();
    }

    public void setTipoMusica(String tipoMusica) {
        this.tipoMusica = tipoMusica;
    }

    public ArrayList<String> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(ArrayList<String> integrantes) {
        this.integrantes = integrantes;
    }

    @Override
    public double getMontoRenta(){
       double seguroDeGrama = montoRenta * 0.3;
       return montoRenta + seguroDeGrama;
   }
    
    
  
}
