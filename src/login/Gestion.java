/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import pantallas.AgregarUsuariosPantalla;

/**
 *
 * @author hnleo
 */
public class Gestion {

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    public static Usuario usuarioActual;
    private static Gestion instancia;
    private AgregarUsuariosPantalla agregar;

    public Gestion() {
        usuarios.add(new Admin("ADMIN", "admin", "supersecreto", 30));

    }

    public static Gestion getInstancia() {
        if (instancia == null) {
            instancia = new Gestion();
        }
        return instancia;

    }

    public String agregarUsuarios(String usuario, String password, String rol, String nombreCompleto, int edad) {
        try {
            if (buscarUsuarios(usuario, 0) == null) {
                if (verificarContraseña(password)) {
                    
                    switch (rol.toUpperCase()) {
                        case "ADMINISTRADOR":
                            usuarios.add(new Admin(nombreCompleto, usuario, password, edad));
                            System.out.println("Usuario admin creado exitosamente.");
                            return "Usuario creado exitosamente";

                        case "CONTENIDO":
                            usuarios.add(new Contenido(nombreCompleto, usuario, password, edad));
                            System.out.println("Usuario contenido creado exitosamente.");
                            return "Usuario creado exitosamente";

                        case "LIMITADO":
                            usuarios.add(new Limitado(nombreCompleto, usuario, password, edad));
                            System.out.println("Usuario limitado creado exitosamente.");
                            return "Usuario creado exitosamente";

                        default:
                            System.out.println("Tipo de rol no admitido, intentelo de nuevo.");
                            return "Error en tipo de usuario.";
                    }
                } else {
                   JOptionPane.showMessageDialog(agregar, mensajeDeContraseña(password), "ADVERTENCIA" , JOptionPane.WARNING_MESSAGE);
    
                }
            } else {

                System.out.println("Usuario ya existe, no puede crearse.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Usuario buscarUsuarios(String usuario, int x) { //Función recursiva #1
        if (x >= usuarios.size()) {
            return null;
        }
        if (usuarios.get(x).getUsuario().equals(usuario)) {
            return usuarios.get(x);
        }

        return buscarUsuarios(usuario, x + 1);

    }

    public boolean verificarContraseña(String password) {
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+]).{8,}$");

    }

    public String mensajeDeContraseña(String password) {
        if (password.length() < 8) {
            return "La contraseña debe tener al menos 8 carácteres.";
        } else if (!password.matches(".*[A-Za-z].")) {
            return "La contraseña debe tener al menos una letra mayúscula o minúscula.";
        } else if (!password.matches(".*\\d*.")) {
            return "La contraseña debe tener al menos un dígito del 0-9";
        } else if (!password.matches(".*[!@#$%^&*()_+].*")) {
            return "La contraseña debe tener al menos un carácter especial.";
        } else {
            return "";

        }
    }

    public boolean loginCuenta(String usuario, String password) {
        Usuario user = buscarUsuarios(usuario, 0);
        try{
        if (user != null) {
            if (user.getUsuario().equals(usuario) && user.getPass().equals(password)) {
                if (user.getTipoRol().equals("ADMIN")) {
                    usuarioActual = user;
                    return true;
                } else if (user.getTipoRol().equals("CONTENIDO")) {
                    usuarioActual = user;
                    return true;
                } else if (user.getTipoRol().equals("LIMITADO")) {
                    usuarioActual = user;
                    return true;
                } else {
                    return false;
                }

            }
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

}
