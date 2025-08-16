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
public abstract class Eventos {
    protected int codigoEvento;
    protected String tituloEvento;
    protected String descripcionEvento;
    protected Calendar fechaARealizar;
    protected double montoRenta;
    protected boolean cancelado;
    protected int cantidadPersonas;
    protected Calendar fechaHoy;
  
    
    public Eventos (int codigoEvento, String tituloEvento, String descripcionEvento, Calendar fechaARealizar, double montoRenta, int cantidadPersonas){
        this.codigoEvento = codigoEvento;
        this.tituloEvento = tituloEvento;
        this.descripcionEvento = descripcionEvento;
        this.fechaARealizar = fechaARealizar;
        this.montoRenta = montoRenta;
        this.cantidadPersonas = cantidadPersonas;
     
        cancelado = false;
        fechaHoy = Calendar.getInstance();
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }
    public String getCancelado(){
        if(cancelado){
            return "Cancelado";
        }
        if(fechaARealizar.getTime().before(fechaHoy.getTime())){
            return "Realizado";
        }
        return "Activo";
    }
    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(int codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public String getTituloEvento() {
        return tituloEvento;
    }

    public void setTituloEvento(String tituloEvento) {
        this.tituloEvento = tituloEvento;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public Calendar getFechaARealizar() {
        return fechaARealizar;
    }

    public void setFechaARealizar(Calendar fechaARealizar) {
        this.fechaARealizar = fechaARealizar;
    }

    public double getMontoRenta() {
        return montoRenta;
    }

    public void setMontoRenta(double montoRenta) {
        this.montoRenta = montoRenta;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }
    
    
    public abstract String getTipoEvento();
    
    
}
