/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import java.util.ArrayList;

/**
 *
  * @author hnleo
 */
public abstract class Usuario {
    protected String nombreCompleto;
    protected String usuario;
    protected String password;
    protected int edad;
    protected ArrayList<Integer> eventosIds = new ArrayList<>();
            
    
    public Usuario(String nombreCompleto, String usuario, String password, int edad){
        this.nombreCompleto = nombreCompleto;
        this.usuario = usuario;
        this.password = password;
        this.edad = edad;
        
    }
    
    public String getNombreCompleto(){
        return nombreCompleto;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public String getPass(){
        return password;
    }
         
    public int getEdad(){
        return edad;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
   public ArrayList<Integer> getEventos() {
        return eventosIds;
    }
   
   public void setEventos(ArrayList<Integer> eventos) {
        eventosIds = eventos;
    }
    public void agregarEventos(int id){
        eventosIds.add(id);
    }
    
    public String print(){
        return "Nombre: "+ nombreCompleto+ 
                "\nUsuario: "+ usuario+
                "\nContraseña: "+ password;
    }
            
    public abstract String getTipoRol();
}
