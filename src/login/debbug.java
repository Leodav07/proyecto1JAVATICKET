/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import java.util.Scanner;

/**
 *
 * @author hnleo
 */
public class debbug {

    public static void main(String[] args) {
        Gestion gestor = new Gestion();

        Scanner leer = new Scanner(System.in);
        System.out.println("Agregar Usuarios\n");
        leer.useDelimiter("\n");
        System.out.print("¿Desea Agregar usuario? s/n: ");
        String resp = leer.next();
        if (resp.equalsIgnoreCase("s")) {
            System.out.print("¿Que tipo de usuario desea crear? ADMIN/CONTENIDO/LIMITADO: ");
            String rol = leer.next();
            System.out.print("\nNombre completo: ");
            String nombreCompleto = leer.next();
            System.out.print("\nusuario: ");
            String usuario = leer.next();
            System.out.print("\nContraseña: ");
            String password = leer.next();
            System.out.print("\nEdad: ");
            int edad = leer.nextInt();

            gestor.agregarUsuarios(usuario, password, rol, nombreCompleto, edad);
            
            
        }else if(resp.equalsIgnoreCase("n")){
            System.out.println("Nombre de usuario: ");
            String usuario = leer.next();
            System.out.println("Nombre de Contraseña: ");
            String password = leer.next();
            
            if(gestor.loginCuenta(usuario, password))
            {
                System.out.println("Bienvenido: "+usuario);
            }else{
                System.out.println("Usuario o contraseña incorrecta.");
            }
        }

    }
}
