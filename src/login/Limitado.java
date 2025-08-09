/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

/**
 *
 * @author hnleo
 */
public class Limitado extends Usuario {

    public Limitado(String nombreCompleto, String usuario, String password, int edad) {
        super(nombreCompleto, usuario, password, edad);

    }

    @Override
    public String getTipoRol() {
        return "LIMITADO";
    }

    public void agregarEventos(String id){
        System.out.println("Usuario limitado no tiene permitido agregar eventos.");
    }
}
