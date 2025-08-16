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
    private String tipoDeporte;
    private ArrayList<String> listaJugadoresEquipo1;
    private ArrayList<String> listaJugadoresEquipo2;
    public EventoDeportivo(int codigoEvento, String tituloEvento, String descripcionEvento, Calendar fechaARealizar, double montoRenta, String nombreEquipo1, String nombreEquipo2, String tipoDeporte, int cantidadPersonas) {
        super(codigoEvento, tituloEvento, descripcionEvento, fechaARealizar, montoRenta, cantidadPersonas);
        this.nombreEquipo1 = nombreEquipo1;
        this.nombreEquipo2 = nombreEquipo2;
       this.tipoDeporte = tipoDeporte;
       listaJugadoresEquipo1 = new ArrayList<>();
       listaJugadoresEquipo2 = new ArrayList<>();
       
    }

    @Override
    public String getTipoEvento() {
        return "DEPORTIVO";
    }

    public String getTipoDeporte() {
        return tipoDeporte;
    }
    @Override
    public String getCancelado(){
        return super.getCancelado();
    }
    public void setNombreEquipo1(String nombreEquipo1) {
        this.nombreEquipo1 = nombreEquipo1;
    }

    public void setNombreEquipo2(String nombreEquipo2) {
        this.nombreEquipo2 = nombreEquipo2;
    }

    public void setTipoDeporte(String tipoDeporte) {
        this.tipoDeporte = tipoDeporte;
    }

    public ArrayList<String> getListaJugadoresEquipo1() {
        return listaJugadoresEquipo1;
    }

    public void setListaJugadoresEquipo1(ArrayList<String> nombreJugador) {
        this.listaJugadoresEquipo1 = nombreJugador;
    }

    public ArrayList<String> getListaJugadoresEquipo2() {
        return listaJugadoresEquipo2;
    }

    public void setListaJugadoresEquipo2(ArrayList<String> nombreJugador) {
        this.listaJugadoresEquipo2 = nombreJugador;
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
    
  

}
