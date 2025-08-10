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
public class EventoDeportivo extends Eventos {

    private ArrayList<String> equipo1;
    private ArrayList<String> equipo2;
    private String nombreEquipo1;
    private String nombreEquipo2;

    public EventoDeportivo(int codigoEvento, String tituloEvento, String descripcionEvento, Calendar fechaARealizar, double montoRenta, String nombreEquipo1, String nombreEquipo2) {
        super(codigoEvento, tituloEvento, descripcionEvento, fechaARealizar, montoRenta);
        this.nombreEquipo1 = nombreEquipo1;
        this.nombreEquipo2 = nombreEquipo2;
    }

    @Override
    String getTipoEvento() {
        return "DEPORTIVO";
    }

    @Override
    double calcularMonto() {
        return 0;
    }

    public String getNombreEquipo1() {
        return nombreEquipo1;
    }

    public String getNombreEquipo2() {
        return nombreEquipo2;
    }

    public ArrayList<String> getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(ArrayList<String> equipo1) {
        this.equipo1 = equipo1;
    }

    public ArrayList<String> getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(ArrayList<String> equipo2) {
        this.equipo2 = equipo2;
    }
    
   public enum TipoDeporte{
        FUTBOL, TENIS, RUGBY, BASEBALL
    }

}
