package pantallas;

import com.toedter.calendar.JDateChooser;
import events.EventoDeportivo;
import events.EventoMusical;
import events.EventoReligioso;
import events.Eventos;
import events.TipoDeporte;
import events.TipoMusica;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;
import login.Gestion;

/**
 * @author hnleo
 */
public class EditarEventosPantalla extends JFrame {

    private JLabel labelTipoEvento, labelCodigo, labelTituloEvento, labelDescripcion, labelFecha, labelMonto, labelMaxPersonas;
    private JLabel labelEquipo1, labelEquipo2, labelTipoDeporte, labelTipoMusica;
    private JTextField textCodigo, textTituloEvento, textDescripcion, textMonto, textMaxPersonas;
    private JDateChooser dateChooser = new JDateChooser();
    private JTextField textEquipo1, textEquipo2;
    private JComboBox<String> comboTipoEvento;
    private JComboBox<TipoDeporte> comboTipoDeporte;
    private JComboBox<TipoMusica> comboTipoMusica;
    private JButton editarEventoButton, cancelarButton, regresarButton;
    private JLabel labelJugadoresEq1, labelJugadoresEq2;
    private JTextField textJugadoresEq1, textJugadoresEq2;
    private JButton btnAgregarJugEq1, btnAgregarJugEq2;
    private JLabel labelIntegrantes;
    private JTextField textIntegrantes;
    private JButton btnAgregarIntegrante;
    private JLabel labelPersonasConvertidas;
    private JTextField textPersonasConvertidas;
    private JButton btnAgregarPersonaConvertida;

    private final int labelWidth = 180;
    private final int labelHeight = 25;
    private final int fieldWidth = 250;
    private final int fieldHeight = 25;
    private final int startXLabel = 30;
    private final int startXField = 220;
    private final int startY = 100;
    private final int spacingY = 40;
    private final int btnWidth = 120;
    private final int btnHeight = 30;

    private JPanel panelPrincipal;
    private Gestion gestion;

    private ArrayList<String> listaJugEq1 = new ArrayList<>();
    private ArrayList<String> listaJugEq2 = new ArrayList<>();
    private ArrayList<String> listaIntegrantes = new ArrayList<>();
    private ArrayList<String> listaPersonasConvertidas = new ArrayList<>();

    public EditarEventosPantalla() {
        pantalla();
        configurarVentana();
        agregarComponentes();

        gestion = Gestion.getInstancia();

        agregarEventos();
        ajustarCamposSegunTipo("DEPORTIVO");

        comboTipoEvento.setEnabled(false);
        comboTipoDeporte.setEnabled(false);
        comboTipoMusica.setEnabled(false);
        textEquipo1.setEnabled(false);
        textEquipo2.setEnabled(false);
    }

    private void pantalla() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.WHITE);

        JLabel labelTitulo = new JLabel("JAVA EVENTS", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Verdana", Font.BOLD, 24));
        labelTitulo.setBounds(0, 20, 550, 40);
        panelPrincipal.add(labelTitulo);

        JLabel labelSubtitulo = new JLabel("Edición de Evento", SwingConstants.CENTER);
        labelSubtitulo.setFont(new Font("Verdana", Font.PLAIN, 14));
        labelSubtitulo.setBounds(0, 60, 550, 20);
        panelPrincipal.add(labelSubtitulo);

        labelTipoEvento = new JLabel("Tipo de Evento:");
        comboTipoEvento = new JComboBox<>(new String[]{"DEPORTIVO", "MUSICAL", "RELIGIOSO"});
        labelCodigo = new JLabel("Código:");
        textCodigo = new JTextField();
        labelMaxPersonas = new JLabel("Cantidad de Personas:");
        textMaxPersonas = new JTextField();
        labelTituloEvento = new JLabel("Título:");
        textTituloEvento = new JTextField();
        labelDescripcion = new JLabel("Descripción:");
        textDescripcion = new JTextField();
        labelFecha = new JLabel("Fecha (dd/mm/aaaa):");
        dateChooser = new JDateChooser();
        labelMonto = new JLabel("Monto de renta (Lps):");
        textMonto = new JTextField();

        labelEquipo1 = new JLabel("Equipo 1:");
        textEquipo1 = new JTextField();
        labelEquipo2 = new JLabel("Equipo 2:");
        textEquipo2 = new JTextField();

        labelJugadoresEq1 = new JLabel("Jugadores Equipo 1:");
        textJugadoresEq1 = new JTextField();
        btnAgregarJugEq1 = new JButton("Agregar");

        labelJugadoresEq2 = new JLabel("Jugadores Equipo 2:");
        textJugadoresEq2 = new JTextField();
        btnAgregarJugEq2 = new JButton("Agregar");

        labelIntegrantes = new JLabel("Integrantes:");
        textIntegrantes = new JTextField();
        btnAgregarIntegrante = new JButton("Agregar");

        labelPersonasConvertidas = new JLabel("Personas convertidas:");
        textPersonasConvertidas = new JTextField();
        btnAgregarPersonaConvertida = new JButton("Agregar");

        labelTipoDeporte = new JLabel("Tipo de Deporte:");
        comboTipoDeporte = new JComboBox<>(TipoDeporte.values());
        labelTipoMusica = new JLabel("Tipo de Música:");
        comboTipoMusica = new JComboBox<>(TipoMusica.values());

        editarEventoButton = new JButton("Guardar Cambios");
        cancelarButton = new JButton("Cancelar");
        regresarButton = new JButton("Regresar");
    }

    private void configurarVentana() {
        this.setSize(550, 720);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("JAVA EVENTS");
        this.add(panelPrincipal);
        panelPrincipal.setBounds(0, 0, 550, 720);
    }

    private void agregarComponentes() {
        int y = startY;

        labelTipoEvento.setBounds(startXLabel, y, labelWidth, labelHeight);
        comboTipoEvento.setBounds(startXField, y, fieldWidth, fieldHeight);
        panelPrincipal.add(labelTipoEvento);
        panelPrincipal.add(comboTipoEvento);

        y += spacingY;
        labelCodigo.setBounds(startXLabel, y, labelWidth, labelHeight);
        textCodigo.setBounds(startXField, y, fieldWidth, fieldHeight);
        panelPrincipal.add(labelCodigo);
        panelPrincipal.add(textCodigo);

        y += spacingY;
        labelTituloEvento.setBounds(startXLabel, y, labelWidth, labelHeight);
        textTituloEvento.setBounds(startXField, y, fieldWidth, fieldHeight);
        panelPrincipal.add(labelTituloEvento);
        panelPrincipal.add(textTituloEvento);

        y += spacingY;
        labelDescripcion.setBounds(startXLabel, y, labelWidth, labelHeight);
        textDescripcion.setBounds(startXField, y, fieldWidth, fieldHeight);
        panelPrincipal.add(labelDescripcion);
        panelPrincipal.add(textDescripcion);

        y += spacingY;
        labelFecha.setBounds(startXLabel, y, labelWidth, labelHeight);
        dateChooser.setBounds(startXField, y, fieldWidth, fieldHeight);
        panelPrincipal.add(labelFecha);
        panelPrincipal.add(dateChooser);

        y += spacingY;
        labelMonto.setBounds(startXLabel, y, labelWidth, labelHeight);
        textMonto.setBounds(startXField, y, fieldWidth, fieldHeight);
        panelPrincipal.add(labelMonto);
        panelPrincipal.add(textMonto);

        editarEventoButton.setBounds(startXLabel, y + 6 * spacingY, btnWidth, btnHeight);
        cancelarButton.setBounds(startXField, y + 6 * spacingY, btnWidth, btnHeight);
        regresarButton.setBounds((550 - btnWidth) / 2, y + 6 * spacingY + btnHeight + 10, btnWidth, btnHeight);
        panelPrincipal.add(editarEventoButton);
        panelPrincipal.add(cancelarButton);
        panelPrincipal.add(regresarButton);
    }

    private void agregarEventos() {
        comboTipoEvento.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String seleccion = (String) comboTipoEvento.getSelectedItem();
                ajustarCamposSegunTipo(seleccion);
            }
        });

        regresarButton.addActionListener(e -> {
            // Validar si existe GestionEventosPantalla, sino cerrar la ventana actual
            try {
                new GestionEventosPantalla().setVisible(true);
            } catch (Exception ex) {
                // Si no existe la clase, simplemente cerrar esta ventana
                JOptionPane.showMessageDialog(this, "Regresando al menú principal...");
            }
            this.dispose();
        });

        textCodigo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String texto = textCodigo.getText().trim();
                if (texto.isEmpty()) {
                    return;
                }
                int codigo;

                try {
                    codigo = Integer.parseInt(texto);
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(EditarEventosPantalla.this, "El código debe ser numérico.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    textCodigo.requestFocus();
                    return;
                }

                // Verificar que el evento pertenece al usuario actual
                 Eventos evento = gestion.buscarEventos(codigo, 0);
                if (evento == null) {
                    JOptionPane.showMessageDialog(EditarEventosPantalla.this, "Evento no encontrado.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    crearDeshabilitado();
                    textCodigo.setText("");
                    textCodigo.requestFocus();
                    return;
                }
                
                try {
                    if (gestion.usuarioActual == null || !gestion.usuarioActual.getEventos().contains(codigo)) {
                        JOptionPane.showMessageDialog(EditarEventosPantalla.this, "Este evento no pertenece a tu cuenta.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                } catch (Exception ex) {
                    // Manejar caso donde usuarioActual es null
                    JOptionPane.showMessageDialog(EditarEventosPantalla.this, "Error: No hay usuario logueado.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

               
                
                if (gestion.buscarEventos(codigo, 0).isCancelado()) {
                     JOptionPane.showMessageDialog(EditarEventosPantalla.this, "Evento cancelado, no puedes realizar cambios.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    return;
                    }

                textTituloEvento.setText(evento.getTituloEvento());
                textDescripcion.setText(evento.getDescripcionEvento());
                dateChooser.setCalendar(evento.getFechaARealizar());
                textMonto.setText(String.valueOf(evento.getMontoRenta()));
                textMaxPersonas.setText(String.valueOf(evento.getCantidadPersonas()));

                listaJugEq1.clear();
                listaJugEq2.clear();
                listaIntegrantes.clear();
                listaPersonasConvertidas.clear();

                if (evento instanceof EventoDeportivo) {
                    comboTipoEvento.setSelectedItem("DEPORTIVO");
                    ajustarCamposSegunTipo("DEPORTIVO");
                    EventoDeportivo dep = (EventoDeportivo) evento;
                    textEquipo1.setText(dep.getNombreEquipo1());
                    textEquipo2.setText(dep.getNombreEquipo2());

                    if (dep.getListaJugadoresEquipo1() != null) {
                        listaJugEq1.addAll(dep.getListaJugadoresEquipo1());
                        textJugadoresEq1.setText(String.join(", ", listaJugEq1));
                    } else {
                        textJugadoresEq1.setText("");
                    }

                    if (dep.getListaJugadoresEquipo2() != null) {
                        listaJugEq2.addAll(dep.getListaJugadoresEquipo2());
                        textJugadoresEq2.setText(String.join(", ", listaJugEq2));
                    } else {
                        textJugadoresEq2.setText("");
                    }

                    try {
                        comboTipoDeporte.setSelectedItem(TipoDeporte.valueOf(String.valueOf(dep.getTipoDeporte()).toUpperCase()));
                    } catch (Exception ex) {
                        // Si no se puede convertir, mantener el valor por defecto
                    }

                } else if (evento instanceof EventoMusical) {
                    comboTipoEvento.setSelectedItem("MUSICAL");
                    ajustarCamposSegunTipo("MUSICAL");
                    EventoMusical mus = (EventoMusical) evento;
                    try {
                        comboTipoMusica.setSelectedItem(TipoMusica.valueOf(String.valueOf(mus.getTipoMusica()).toUpperCase()));
                    } catch (Exception ex) {
                        // Si no se puede convertir, mantener el valor por defecto
                    }

                    try {
                        if (mus.getIntegrantes() != null) {
                            listaIntegrantes.addAll(mus.getIntegrantes());
                            textIntegrantes.setText(String.join(", ", listaIntegrantes));
                        } else {
                            textIntegrantes.setText("");
                        }
                    } catch (Exception ex) {
                        textIntegrantes.setText("");
                    }

                } else if (evento instanceof EventoReligioso) {
                    comboTipoEvento.setSelectedItem("RELIGIOSO");
                    ajustarCamposSegunTipo("RELIGIOSO");

                    EventoReligioso rel = (EventoReligioso) evento;
                    try {
                        if (rel.getPersonasConvertidas() != null) {
                            listaPersonasConvertidas.addAll(rel.getPersonasConvertidas());
                            textPersonasConvertidas.setText(String.join(", ", listaPersonasConvertidas));
                        } else {
                            textPersonasConvertidas.setText("");
                        }
                    } catch (Exception ex) {
                        textPersonasConvertidas.setText("");
                    }
                }

                textCodigo.setEnabled(false);
                crearHabilitado();
            }
        });

        cancelarButton.addActionListener(e -> {
            limpiarCampos();
            textCodigo.setEnabled(true);
            crearHabilitado();
        });

        // Botones para agregar elementos a las listas
        btnAgregarJugEq1.addActionListener(e -> {
            String entrada = JOptionPane.showInputDialog(this, "Ingrese el nombre del jugador:");
            if (entrada != null && !entrada.trim().isEmpty()) {
                listaJugEq1.add(entrada.trim());
                textJugadoresEq1.setText(String.join(", ", listaJugEq1));
            }
        });

        btnAgregarJugEq2.addActionListener(e -> {
            String entrada = JOptionPane.showInputDialog(this, "Ingrese el nombre del jugador:");
            if (entrada != null && !entrada.trim().isEmpty()) {
                listaJugEq2.add(entrada.trim());
                textJugadoresEq2.setText(String.join(", ", listaJugEq2));
            }
        });

        btnAgregarIntegrante.addActionListener(e -> {
            String entrada = JOptionPane.showInputDialog(this, "Ingrese el nombre del integrante:");
            if (entrada != null && !entrada.trim().isEmpty()) {
                listaIntegrantes.add(entrada.trim());
                textIntegrantes.setText(String.join(", ", listaIntegrantes));
            }
        });

        btnAgregarPersonaConvertida.addActionListener(e -> {
            String entrada = JOptionPane.showInputDialog(this, "Ingrese el nombre de la persona convertida:");
            if (entrada != null && !entrada.trim().isEmpty()) {
                listaPersonasConvertidas.add(entrada.trim());
                textPersonasConvertidas.setText(String.join(", ", listaPersonasConvertidas));
            }
        });

        editarEventoButton.addActionListener(e -> {
            try {
                if (textCodigo.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Debe ingresar un código de evento.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (textTituloEvento.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Debe ingresar un título para el evento.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (dateChooser.getCalendar() == null) {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar una fecha.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int codigo = Integer.parseInt(textCodigo.getText());
                String tipo = (String) comboTipoEvento.getSelectedItem();
                Calendar fecha = dateChooser.getCalendar();
                double monto = Double.parseDouble(textMonto.getText());
                int cantidad = Integer.parseInt(textMaxPersonas.getText());

                if ("DEPORTIVO".equals(tipo) && cantidad > 20000) {
                    JOptionPane.showMessageDialog(this, "Cantidad de personas máxima permitida para eventos deportivos: 20,000", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    return;
                } else if ("MUSICAL".equals(tipo) && cantidad > 25000) {
                    JOptionPane.showMessageDialog(this, "Cantidad de personas máxima permitida para eventos musicales: 25,000", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    return;
                } else if ("RELIGIOSO".equals(tipo) && cantidad > 30000) {
                    JOptionPane.showMessageDialog(this, "Cantidad de personas máxima permitida para eventos religiosos: 30,000", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String nombreEq1 = textEquipo1.getText();
                String nombreEq2 = textEquipo2.getText();
                String tDeporte = comboTipoDeporte.getSelectedItem() != null ? comboTipoDeporte.getSelectedItem().toString() : "";
                String tMusica = comboTipoMusica.getSelectedItem() != null ? comboTipoMusica.getSelectedItem().toString() : "";

                try {
                    Eventos eventoActualizado = gestion.buscarEventos(codigo, 0);
                    if (eventoActualizado != null) {
                        if (eventoActualizado instanceof EventoDeportivo) {
                            EventoDeportivo dep = (EventoDeportivo) eventoActualizado;
                            dep.setListaJugadoresEquipo1(new ArrayList<>(listaJugEq1));
                            dep.setListaJugadoresEquipo2(new ArrayList<>(listaJugEq2));
                        } else if (eventoActualizado instanceof EventoMusical) {
                            EventoMusical mus = (EventoMusical) eventoActualizado;
                            mus.setIntegrantes(new ArrayList<>(listaIntegrantes));
                        } else if (eventoActualizado instanceof EventoReligioso) {
                            EventoReligioso rel = (EventoReligioso) eventoActualizado;
                            rel.setPersonasConvertidas(new ArrayList<>(listaPersonasConvertidas));
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("Error al actualizar listas: " + ex.getMessage());
                }

                String resultado = gestion.editarEvento(
                        codigo,
                        textTituloEvento.getText(),
                        textDescripcion.getText(),
                        fecha,
                        monto,
                        tipo,
                        nombreEq1,
                        nombreEq2,
                        tDeporte,
                        tMusica,
                        cantidad,
                        new ArrayList<>(listaJugEq1),
                        new ArrayList<>(listaJugEq2),
                        new ArrayList<>(listaIntegrantes),
                        new ArrayList<>(listaPersonasConvertidas)
                );

                JOptionPane.showMessageDialog(EditarEventosPantalla.this, resultado, "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                textCodigo.setEnabled(true);
                crearHabilitado();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(EditarEventosPantalla.this, "Complete los campos numéricos correctamente.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(EditarEventosPantalla.this, "Error al editar evento: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void crearDeshabilitado() {
        editarEventoButton.setEnabled(false);
    }

    private void crearHabilitado() {
        editarEventoButton.setEnabled(true);
    }

    private void ajustarCamposSegunTipo(String tipoEvento) {
        panelPrincipal.remove(labelEquipo1);
        panelPrincipal.remove(textEquipo1);
        panelPrincipal.remove(labelEquipo2);
        panelPrincipal.remove(textEquipo2);
        panelPrincipal.remove(labelTipoDeporte);
        panelPrincipal.remove(comboTipoDeporte);
        panelPrincipal.remove(labelTipoMusica);
        panelPrincipal.remove(comboTipoMusica);
        panelPrincipal.remove(labelMaxPersonas);
        panelPrincipal.remove(textMaxPersonas);

        panelPrincipal.remove(labelJugadoresEq1);
        panelPrincipal.remove(textJugadoresEq1);
        panelPrincipal.remove(btnAgregarJugEq1);
        panelPrincipal.remove(labelJugadoresEq2);
        panelPrincipal.remove(textJugadoresEq2);
        panelPrincipal.remove(btnAgregarJugEq2);

        panelPrincipal.remove(labelIntegrantes);
        panelPrincipal.remove(textIntegrantes);
        panelPrincipal.remove(btnAgregarIntegrante);

        panelPrincipal.remove(labelPersonasConvertidas);
        panelPrincipal.remove(textPersonasConvertidas);
        panelPrincipal.remove(btnAgregarPersonaConvertida);

        int y = startY + 6 * spacingY;

        if ("DEPORTIVO".equals(tipoEvento)) {
            labelEquipo1.setBounds(startXLabel, y, labelWidth, labelHeight);
            textEquipo1.setBounds(startXField, y, fieldWidth, fieldHeight);
            panelPrincipal.add(labelEquipo1);
            panelPrincipal.add(textEquipo1);
            y += spacingY;

            labelEquipo2.setBounds(startXLabel, y, labelWidth, labelHeight);
            textEquipo2.setBounds(startXField, y, fieldWidth, fieldHeight);
            panelPrincipal.add(labelEquipo2);
            panelPrincipal.add(textEquipo2);
            y += spacingY;

            labelJugadoresEq1.setBounds(startXLabel, y, labelWidth, labelHeight);
            textJugadoresEq1.setBounds(startXField, y, fieldWidth - 100, fieldHeight);
            btnAgregarJugEq1.setBounds(startXField + fieldWidth - 90, y, 90, fieldHeight);
            panelPrincipal.add(labelJugadoresEq1);
            panelPrincipal.add(textJugadoresEq1);
            panelPrincipal.add(btnAgregarJugEq1);
            y += spacingY;

            labelJugadoresEq2.setBounds(startXLabel, y, labelWidth, labelHeight);
            textJugadoresEq2.setBounds(startXField, y, fieldWidth - 100, fieldHeight);
            btnAgregarJugEq2.setBounds(startXField + fieldWidth - 90, y, 90, fieldHeight);
            panelPrincipal.add(labelJugadoresEq2);
            panelPrincipal.add(textJugadoresEq2);
            panelPrincipal.add(btnAgregarJugEq2);
            y += spacingY;

            labelTipoDeporte.setBounds(startXLabel, y, labelWidth, labelHeight);
            comboTipoDeporte.setBounds(startXField, y, fieldWidth, fieldHeight);
            panelPrincipal.add(labelTipoDeporte);
            panelPrincipal.add(comboTipoDeporte);
            y += spacingY;

            labelMaxPersonas.setBounds(startXLabel, y, labelWidth, labelHeight);
            textMaxPersonas.setBounds(startXField, y, fieldWidth, fieldHeight);
            labelMaxPersonas.setText("Cantidad de pers. (Max. 20,000):");
            panelPrincipal.add(labelMaxPersonas);
            panelPrincipal.add(textMaxPersonas);
            y += spacingY;

        } else if ("MUSICAL".equals(tipoEvento)) {
            labelTipoMusica.setBounds(startXLabel, y, labelWidth, labelHeight);
            comboTipoMusica.setBounds(startXField, y, fieldWidth, fieldHeight);
            panelPrincipal.add(labelTipoMusica);
            panelPrincipal.add(comboTipoMusica);
            y += spacingY;

            labelMaxPersonas.setBounds(startXLabel, y, labelWidth, labelHeight);
            textMaxPersonas.setBounds(startXField, y, fieldWidth, fieldHeight);
            labelMaxPersonas.setText("Cantidad de pers. (Max. 25,000):");
            panelPrincipal.add(labelMaxPersonas);
            panelPrincipal.add(textMaxPersonas);
            y += spacingY;

            labelIntegrantes.setBounds(startXLabel, y, labelWidth, labelHeight);
            textIntegrantes.setBounds(startXField, y, fieldWidth - 100, fieldHeight);
            btnAgregarIntegrante.setBounds(startXField + fieldWidth - 90, y, 90, fieldHeight);
            panelPrincipal.add(labelIntegrantes);
            panelPrincipal.add(textIntegrantes);
            panelPrincipal.add(btnAgregarIntegrante);
            y += spacingY;

        } else if ("RELIGIOSO".equals(tipoEvento)) {
            labelMaxPersonas.setBounds(startXLabel, y, labelWidth, labelHeight);
            textMaxPersonas.setBounds(startXField, y, fieldWidth, fieldHeight);
            labelMaxPersonas.setText("Cantidad de pers. (Max. 30,000):");
            panelPrincipal.add(labelMaxPersonas);
            panelPrincipal.add(textMaxPersonas);
            y += spacingY;

            labelPersonasConvertidas.setBounds(startXLabel, y, labelWidth, labelHeight);
            textPersonasConvertidas.setBounds(startXField, y, fieldWidth - 100, fieldHeight);
            btnAgregarPersonaConvertida.setBounds(startXField + fieldWidth - 90, y, 90, fieldHeight);
            panelPrincipal.add(labelPersonasConvertidas);
            panelPrincipal.add(textPersonasConvertidas);
            panelPrincipal.add(btnAgregarPersonaConvertida);
            y += spacingY;
        }

        editarEventoButton.setBounds(startXLabel, y + 10, btnWidth, btnHeight);
        cancelarButton.setBounds(startXField, y + 10, btnWidth, btnHeight);
        regresarButton.setBounds((550 - btnWidth) / 2, y + 10 + btnHeight + 10, btnWidth, btnHeight);

        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

    private void limpiarCampos() {
        textCodigo.setText("");
        textTituloEvento.setText("");
        textDescripcion.setText("");
        dateChooser.setCalendar(null);
        textMonto.setText("");
        textMaxPersonas.setText("");
        textEquipo1.setText("");
        textEquipo2.setText("");
        comboTipoDeporte.setSelectedIndex(0);
        comboTipoMusica.setSelectedIndex(0);
        comboTipoEvento.setSelectedIndex(0);

        listaJugEq1.clear();
        listaJugEq2.clear();
        listaIntegrantes.clear();
        listaPersonasConvertidas.clear();

        textJugadoresEq1.setText("");
        textJugadoresEq2.setText("");
        textIntegrantes.setText("");
        textPersonasConvertidas.setText("");
    }
}
