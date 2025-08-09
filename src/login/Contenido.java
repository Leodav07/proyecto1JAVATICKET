/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

/**
 *
 * @author hnleo
 */
public class Contenido extends Usuario {

    public Contenido(String nombreCompleto, String usuario, String password, int edad) {
        super(nombreCompleto, usuario, password, edad);
    }

    @Override
    public String getTipoRol() {
        return "CONTENIDO";
    }
}
