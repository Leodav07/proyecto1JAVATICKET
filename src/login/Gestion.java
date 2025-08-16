/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import events.EventoDeportivo;
import events.EventoMusical;
import events.EventoReligioso;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import login.Admin;
import login.Contenido;
import login.Limitado;
import login.Usuario;
import pantallas.AgregarUsuariosPantalla;
import events.Eventos;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import pantallas.EditarEventosPantalla;

/**
 *
 * @author hnleo
 */
public final class Gestion {

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    public static Usuario usuarioActual;
    private static Gestion instancia;
    private AgregarUsuariosPantalla agregar;
    private ArrayList<Eventos> eventos = new ArrayList<>();
    private Calendar fechaHoy;

    public Gestion() {
        usuarios.add(new Admin("ADMIN", "admin", "supersecreto", 30));
        fechaHoy = Calendar.getInstance();

    }

    public static Gestion getInstancia() {
        if (instancia == null) {
            instancia = new Gestion();
        }
        return instancia;

    }

    public final String agregarUsuarios(String usuario, String password, String rol, String nombreCompleto, int edad) {
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
                    JOptionPane.showMessageDialog(agregar, mensajeDeContraseña(password), "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);

                }
            } else {

                System.out.println("Usuario ya existe, no puede crearse.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public final String editarUsuario(String usuario, String password, String rol, String nombreCompleto, int edad) {
        try {
            Usuario user = buscarUsuarios(usuario, 0);
            if (user == null) {
                return "Usuario no encontrado.";
            }

            // Verificar si hay algún cambio realmente
            if (user.getUsuario().equals(usuario) && user.getNombreCompleto().equals(nombreCompleto)
                    && user.getPass().equals(password) && user.getTipoRol().equals(rol) && user.getEdad() == edad) {
                return "Para editar un usuario debes realizar al menos un cambio.";
            } else {
                ArrayList<Integer> eventosPrevios = user.getEventos();

                Usuario nuevoUsuario;

                switch (rol) {
                    case "ADMINISTRADOR":
                        nuevoUsuario = new Admin(nombreCompleto, usuario, password, edad);
                        break;
                    case "CONTENIDO":
                        nuevoUsuario = new Contenido(nombreCompleto, usuario, password, edad);
                        break;
                    case "LIMITADO":
                        nuevoUsuario = new Limitado(nombreCompleto, usuario, password, edad);
                        break;
                    default:
                        throw new IllegalArgumentException("Rol desconocido");
                }

                if (!"LIMITADO".equals(nuevoUsuario.getTipoRol())) {
                    nuevoUsuario.setEventos(eventosPrevios);
                }

                int i = encontrarIndice(usuario);
                usuarios.set(i, nuevoUsuario);

                return "Usuario editado correctamente.";
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return "ERROR: " + e.getMessage();
        }
    }

    private int encontrarIndice(String usuario) {
        int i = -1;
        for (int index = 0; index < usuarios.size(); index++) {
            if (usuarios.get(index).getUsuario().equals(usuario)) {
                i = index;
                return i;
            }
        }
        if (i == -1) {
            return i;
        }
        return i;
    }

    private int encontrarIndiceEventos(int codigoEvento) {
        int i = -1;
        for (int index = 0; index < eventos.size(); index++) {
            if (eventos.get(index).getCodigoEvento() == codigoEvento) {
                i = index;
                return i;
            }
        }
        if (i == -1) {
            return i;
        }
        return i;
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

    public final String borrarUsuario(String usuario) {
        try {
            int i = encontrarIndice(usuario);
            usuarios.remove(i);
            return "Usuario eliminado con éxito.";
        } catch (Exception e) {
            return "Ocurrio un error." + e.getMessage();
        }
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

    public final boolean loginCuenta(String usuario, String password) {
        Usuario user = buscarUsuarios(usuario, 0);
        try {
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    //GESTION DE EVENTOS
    public String crearEvento(int codigoEvento, String tituloEvento, String descripcionEvento, Calendar fechaARealizar, double montoRenta, String tipoEvento, String nombreEquipo1, String nombreEquipo2, String tipoDeporte, String tipoMusica, int cantidadPersonas) {

        try {

            if (buscarEventos(codigoEvento, 0) != null) {
                return "Código de evento existente, favor crear otro.";
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY");
            if (sdf.format(fechaARealizar.getTime()).equals(sdf.format(fechaHoy.getTime()))) {
                return "No puedes crear eventos el mismo día.";
            }

            Eventos nuevoEvento;

            switch (tipoEvento) {
                case ("DEPORTIVO"):
                    nuevoEvento = new EventoDeportivo(codigoEvento, tituloEvento, descripcionEvento, fechaARealizar, montoRenta, nombreEquipo1, nombreEquipo2, tipoDeporte, cantidadPersonas);
                    break;
                case ("MUSICAL"):
                    nuevoEvento = new EventoMusical(codigoEvento, tituloEvento, descripcionEvento, fechaARealizar, montoRenta, tipoMusica, cantidadPersonas);
                    break;

                case ("RELIGIOSO"):
                    nuevoEvento = new EventoReligioso(codigoEvento, tituloEvento, descripcionEvento, fechaARealizar, montoRenta, cantidadPersonas);
                    break;

                default:
                    return "Tipo de evento inválido.";

            }

            if (usuarioActual != null && !usuarioActual.getTipoRol().equals("LIMITADO")) {
                Gestion.usuarioActual.getEventos().add(codigoEvento);
            }

            eventos.add(nuevoEvento);

            return "Evento " + tipoEvento + " creado exitosamente.";

        } catch (Exception e) {
            return "Ocurrio un error. " + e.getMessage();
        }

    }

    public Eventos buscarEventos(int codigoEvento, int x) { //Función recursiva #2
        if (x >= eventos.size()) {
            return null;
        }
        if (eventos.get(x).getCodigoEvento() == codigoEvento) {
            return eventos.get(x);
        }

        return buscarEventos(codigoEvento, x + 1);

    }

    public final String editarEvento(int codigoEvento, String tituloEvento, String descripcionEvento, Calendar fechaARealizar, double montoRenta, String tipoEvento,
            String nombreEquipo1,  String nombreEquipo2, String tipoDeporte, String tipoMusica, int cantidadPersonas,
            ArrayList<String> jugadoresEq1,  ArrayList<String> jugadoresEq2,  ArrayList<String> integrantesMusicales,ArrayList<String> personasConvertidas) {
        try {
            Eventos event = buscarEventos(codigoEvento, 0);

            if (event == null) {
                return "Evento no encontrado.";
            }

            if (usuarioActual == null || !usuarioActual.getEventos().contains(codigoEvento)) {
                return "Este evento no pertenece a tu cuenta.";
            }
            
            if(event.isCancelado()){
                return "Evento ya cancelado, no puedes realizar cambios.";
            }

            boolean sinCambios = event.getTituloEvento().equals(tituloEvento)
                    && event.getDescripcionEvento().equals(descripcionEvento)
                    && event.getFechaARealizar().equals(fechaARealizar)
                    && event.getMontoRenta() == montoRenta
                    && event.getCantidadPersonas() == cantidadPersonas;

            if (event instanceof EventoDeportivo) {
                EventoDeportivo dep = (EventoDeportivo) event;
                sinCambios = sinCambios
                        && dep.getNombreEquipo1().equals(nombreEquipo1)
                        && dep.getNombreEquipo2().equals(nombreEquipo2)
                        && dep.getTipoDeporte().equals(tipoDeporte);

                if (dep.getListaJugadoresEquipo1() != null && jugadoresEq1 != null) {
                    sinCambios = sinCambios && dep.getListaJugadoresEquipo1().equals(jugadoresEq1);
                }
                if (dep.getListaJugadoresEquipo2() != null && jugadoresEq2 != null) {
                    sinCambios = sinCambios && dep.getListaJugadoresEquipo2().equals(jugadoresEq2);
                }
            } else if (event instanceof EventoMusical) {
                EventoMusical mus = (EventoMusical) event;
                sinCambios = sinCambios && mus.getTipoMusica().equals(tipoMusica);

                if (mus.getIntegrantes() != null && integrantesMusicales != null) {
                    sinCambios = sinCambios && mus.getIntegrantes().equals(integrantesMusicales);
                }
            } else if (event instanceof EventoReligioso) {
                EventoReligioso rel = (EventoReligioso) event;

                if (rel.getPersonasConvertidas() != null && personasConvertidas != null) {
                    sinCambios = sinCambios && rel.getPersonasConvertidas().equals(personasConvertidas);
                }
            }

            if (sinCambios) {
                return "Para editar un evento debes realizar al menos un cambio.";
            }

            event.setTituloEvento(tituloEvento);
            event.setDescripcionEvento(descripcionEvento);
            event.setFechaARealizar(fechaARealizar);
            event.setMontoRenta(montoRenta);
            event.setCantidadPersonas(cantidadPersonas);

            if (event instanceof EventoDeportivo) {
                EventoDeportivo dep = (EventoDeportivo) event;
                dep.setNombreEquipo1(nombreEquipo1);
                dep.setNombreEquipo2(nombreEquipo2);
                dep.setTipoDeporte(tipoDeporte);

                if (jugadoresEq1 != null) {
                    dep.setListaJugadoresEquipo1(new ArrayList<>(jugadoresEq1));
                }
                if (jugadoresEq2 != null) {
                    dep.setListaJugadoresEquipo2(new ArrayList<>(jugadoresEq2));
                }
            } else if (event instanceof EventoMusical) {
                EventoMusical mus = (EventoMusical) event;
                mus.setTipoMusica(tipoMusica);

                if (integrantesMusicales != null) {
                    mus.setIntegrantes(new ArrayList<>(integrantesMusicales));
                }
            } else if (event instanceof EventoReligioso) {
                EventoReligioso rel = (EventoReligioso) event;

                if (personasConvertidas != null) {
                    rel.setPersonasConvertidas(new ArrayList<>(personasConvertidas));
                }
            }

            return "Evento editado correctamente.";

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return "ERROR: " + e.getMessage();
        }
    }

    public final String editarEvento( //Esta funcion es la misma que arriba, sin embargo si es en un evento religioso utiliza esta para evitar utilizar la de arriba
            int codigoEvento,
            String tituloEvento,
            String descripcionEvento,
            Calendar fechaARealizar,
            double montoRenta,
            String tipoEvento,
            String nombreEquipo1,
            String nombreEquipo2,
            String tipoDeporte,
            String tipoMusica,
            int cantidadPersonas
    ) {

        return editarEvento(
                codigoEvento, tituloEvento, descripcionEvento, fechaARealizar,
                montoRenta, tipoEvento, nombreEquipo1, nombreEquipo2,
                tipoDeporte, tipoMusica, cantidadPersonas,
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
        );
    }

    public final String eliminarEvento(int codigoEvento, Calendar fecha) {
        try {
            if (usuarioActual == null || !usuarioActual.getEventos().contains(codigoEvento)) {
                return "Este evento no pertenece a tu cuenta.";
            }
            
            Eventos event = buscarEventos(codigoEvento, 0);
            event.setCancelado(true);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY");
            fecha.add(Calendar.DAY_OF_MONTH, -1);

            if (event instanceof EventoDeportivo || event instanceof EventoMusical) {
                if (sdf.format(fecha.getTime()).equals(sdf.format(fechaHoy.getTime()))) {
                    double multa = event.getMontoRenta() * 0.5;
                    event.setMontoRenta(multa);

                    return "Evento Cancelado, multa recibida: " + multa + " Lps.";
                }
            } else if (event instanceof EventoReligioso) {
                return "Evento Cancelado, no recibe multa";
            }
            event.setMontoRenta(0);
        } catch (Exception e) {
            return "Ocurrio un error de sistema. " + e.getMessage();
        }
        
        return "Evento Cancelado.";
    }

}
