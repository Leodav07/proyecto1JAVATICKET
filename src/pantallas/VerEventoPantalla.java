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
import javax.swing.*;
import login.Gestion;

/**
 * @author hnleo
 */
public class VerEventoPantalla extends JFrame {

    private JLabel labelTipoEvento, labelCodigo, labelTituloEvento, labelDescripcion, labelFecha, labelMonto, labelMaxPersonas;
    private JLabel labelEquipo1, labelEquipo2, labelTipoDeporte, labelTipoMusica;
    private JTextField textCodigo, textTituloEvento, textDescripcion, textMonto, textMaxPersonas;
    private JDateChooser dateChooser = new JDateChooser();
    private JTextField textEquipo1, textEquipo2;
    private JComboBox<String> comboTipoEvento;
    private JComboBox<TipoDeporte> comboTipoDeporte;
    private JComboBox<TipoMusica> comboTipoMusica;
    private JButton verEventoButton, cancelarButton, regresarButton;
    private JLabel labelJugadoresEq1, labelJugadoresEq2;
    private JTextField textJugadoresEq1, textJugadoresEq2;
    private JLabel labelIntegrantes;
    private JTextField textIntegrantes;
    private JLabel labelPersonasConvertidas;
    private JTextField textPersonasConvertidas;
    private JLabel labelCancelado;
    private JTextField textCancelado;

    private final int labelWidth = 180;
    private final int labelHeight = 25;
    private final int fieldWidth = 250;
    private final int fieldHeight = 25;
    private final int startXLabel = 30;
    private final int startXField = 220;
    private final int startY = 100;
    private final int spacingY = 40;
    private final int btnWidth = 120;
    private final int btnHeight = 35;

    private JPanel panelPrincipal;
    private Gestion gestion;

    private ArrayList<String> listaJugEq1 = new ArrayList<>();
    private ArrayList<String> listaJugEq2 = new ArrayList<>();
    private ArrayList<String> listaIntegrantes = new ArrayList<>();
    private ArrayList<String> listaPersonasConvertidas = new ArrayList<>();

    public VerEventoPantalla() {
        pantalla();
        configurarVentana();
        agregarComponentes();

        gestion = Gestion.getInstancia();

        agregarEventos();
        ajustarCamposSegunTipo("DEPORTIVO");
        desactivarCampos();
    }

    private void pantalla() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.WHITE);

        JLabel labelTitulo = new JLabel("JAVA EVENTS", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        labelTitulo.setForeground(new Color(33, 33, 33));
        labelTitulo.setBounds(0, 20, 550, 40);
        panelPrincipal.add(labelTitulo);

        JLabel labelSubtitulo = new JLabel("Cancelar Evento", SwingConstants.CENTER);
        labelSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        labelSubtitulo.setForeground(new Color(100, 100, 100));
        labelSubtitulo.setBounds(0, 65, 550, 25);
        panelPrincipal.add(labelSubtitulo);

        // Inicialización de labels y campos
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
        labelCancelado = new JLabel("Estado:");
        textCancelado = new JTextField();

        labelEquipo1 = new JLabel("Equipo 1:");
        textEquipo1 = new JTextField();
        labelEquipo2 = new JLabel("Equipo 2:");
        textEquipo2 = new JTextField();

        labelJugadoresEq1 = new JLabel("Jugadores Equipo 1:");
        textJugadoresEq1 = new JTextField();
        labelJugadoresEq2 = new JLabel("Jugadores Equipo 2:");
        textJugadoresEq2 = new JTextField();

        labelIntegrantes = new JLabel("Integrantes:");
        textIntegrantes = new JTextField();
        labelPersonasConvertidas = new JLabel("Personas convertidas:");
        textPersonasConvertidas = new JTextField();

        labelTipoDeporte = new JLabel("Tipo de Deporte:");
        comboTipoDeporte = new JComboBox<>(TipoDeporte.values());
        labelTipoMusica = new JLabel("Tipo de Música:");
        comboTipoMusica = new JComboBox<>(TipoMusica.values());

        verEventoButton = new JButton("Ver Evento");
        cancelarButton = new JButton("Cancelar");
        regresarButton = new JButton("Regresar");

        JLabel[] labels = {labelTipoEvento, labelCodigo, labelTituloEvento, labelDescripcion, labelFecha,
            labelMonto, labelMaxPersonas, labelEquipo1, labelEquipo2, labelTipoDeporte, labelTipoMusica,
            labelJugadoresEq1, labelJugadoresEq2, labelIntegrantes, labelPersonasConvertidas, labelCancelado};
        JTextField[] campos = {textCodigo, textTituloEvento, textDescripcion, textMonto, textMaxPersonas,
            textEquipo1, textEquipo2, textJugadoresEq1, textJugadoresEq2, textIntegrantes,
            textPersonasConvertidas, textCancelado};
        JComboBox[] combos = {comboTipoEvento, comboTipoDeporte, comboTipoMusica};

        for (JLabel lbl : labels) {
            lbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
            lbl.setForeground(new Color(50, 50, 50));
        }
        for (JTextField txt : campos) {
            txt.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        }
        for (JComboBox cmb : combos) {
            cmb.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        }

        verEventoButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        verEventoButton.setBackground(new Color(76, 175, 80));
        verEventoButton.setForeground(Color.WHITE);
        verEventoButton.setFocusPainted(false);
        verEventoButton.setBorderPainted(false);

        cancelarButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cancelarButton.setBackground(new Color(244, 67, 54));
        cancelarButton.setForeground(Color.WHITE);
        cancelarButton.setFocusPainted(false);
        cancelarButton.setBorderPainted(false);

        regresarButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        regresarButton.setBackground(new Color(33, 150, 243));
        regresarButton.setForeground(Color.WHITE);
        regresarButton.setFocusPainted(false);
        regresarButton.setBorderPainted(false);
    }

    private void configurarVentana() {
        this.setSize(550, 800);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("JAVA EVENTS");
        JScrollPane scrollPane = new JScrollPane(panelPrincipal);
        scrollPane.setBounds(0, 0, 550, 800);
        this.add(scrollPane);
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

        y += spacingY;
        labelCancelado.setBounds(startXLabel, y, labelWidth, labelHeight);
        textCancelado.setBounds(startXField, y, fieldWidth, fieldHeight);
        panelPrincipal.add(labelCancelado);
        panelPrincipal.add(textCancelado);

        verEventoButton.setBounds(startXLabel, y + 6 * spacingY, btnWidth, btnHeight);
        cancelarButton.setBounds(startXField, y + 6 * spacingY, btnWidth, btnHeight);
        regresarButton.setBounds((550 - btnWidth) / 2, y + 6 * spacingY + btnHeight + 10, btnWidth, btnHeight);
        
        panelPrincipal.add(verEventoButton);
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
            new GestionEventosPantalla().setVisible(true);
            this.dispose();
        });

        verEventoButton.addActionListener(e -> {
            String texto = textCodigo.getText().trim();
            if (texto.isEmpty()) {
                return;
            }

            int codigo;
            try {
                codigo = Integer.parseInt(texto);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El código debe ser numérico.", "ERROR", JOptionPane.ERROR_MESSAGE);
                textCodigo.requestFocus();
                return;
            }

            Eventos evento = gestion.buscarEventos(codigo, 0);
            if (evento == null) {
                JOptionPane.showMessageDialog(this, "Evento no encontrado.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                textCodigo.setText("");
                textCodigo.requestFocus();
                return;
            }

            textTituloEvento.setText(evento.getTituloEvento());
            textDescripcion.setText(evento.getDescripcionEvento());
            dateChooser.setCalendar(evento.getFechaARealizar());
            textMonto.setText(String.valueOf(evento.getMontoRenta()));
            textMaxPersonas.setText(String.valueOf(evento.getCantidadPersonas()));
            textCancelado.setText(evento.getCancelado());

            if (evento instanceof EventoDeportivo) {
                comboTipoEvento.setSelectedItem("DEPORTIVO");
                ajustarCamposSegunTipo("DEPORTIVO");
                EventoDeportivo dep = (EventoDeportivo) evento;
                textEquipo1.setText(dep.getNombreEquipo1());
                textEquipo2.setText(dep.getNombreEquipo2());
                try {
                    comboTipoDeporte.setSelectedItem(TipoDeporte.valueOf(String.valueOf(dep.getTipoDeporte()).toUpperCase()));
                } catch (Exception ex) {
                }
            } else if (evento instanceof EventoMusical) {
                comboTipoEvento.setSelectedItem("MUSICAL");
                ajustarCamposSegunTipo("MUSICAL");
                EventoMusical mus = (EventoMusical) evento;
                try {
                    comboTipoMusica.setSelectedItem(TipoMusica.valueOf(String.valueOf(mus.getTipoMusica()).toUpperCase()));
                } catch (Exception ex) {
                }
            } else if (evento instanceof EventoReligioso) {
                comboTipoEvento.setSelectedItem("RELIGIOSO");
                ajustarCamposSegunTipo("RELIGIOSO");
            }

            textCodigo.setEnabled(false);
        });

        cancelarButton.addActionListener(e -> {
            limpiarCampos();
            textCodigo.setEnabled(true);
            crearHabilitado();
        });
    }

    private void crearDeshabilitado() {
        verEventoButton.setEnabled(false);
    }

    private void crearHabilitado() {
        verEventoButton.setEnabled(true);
    }

    private void ajustarCamposSegunTipo(String tipoEvento) {
        // Remover campos dinámicos
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
        panelPrincipal.remove(labelJugadoresEq2);
        panelPrincipal.remove(textJugadoresEq2);
        panelPrincipal.remove(labelIntegrantes);
        panelPrincipal.remove(textIntegrantes);
        panelPrincipal.remove(labelPersonasConvertidas);
        panelPrincipal.remove(textPersonasConvertidas);

        int y = startY + 7 * spacingY;

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
            panelPrincipal.add(labelJugadoresEq1);
            panelPrincipal.add(textJugadoresEq1);
            y += spacingY;

            labelJugadoresEq2.setBounds(startXLabel, y, labelWidth, labelHeight);
            textJugadoresEq2.setBounds(startXField, y, fieldWidth - 100, fieldHeight);
            panelPrincipal.add(labelJugadoresEq2);
            panelPrincipal.add(textJugadoresEq2);
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
            panelPrincipal.add(labelIntegrantes);
            panelPrincipal.add(textIntegrantes);
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
            panelPrincipal.add(labelPersonasConvertidas);
            panelPrincipal.add(textPersonasConvertidas);
            y += spacingY;
        }

        int yBotones = y + 10;
        verEventoButton.setBounds(startXLabel, yBotones, btnWidth, btnHeight);
        cancelarButton.setBounds(startXField, yBotones, btnWidth, btnHeight);
        regresarButton.setBounds((550-btnWidth)/2, yBotones+btnHeight+10, btnWidth, btnHeight);

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
        textCancelado.setText("");
    }

    private void desactivarCampos() {
        textDescripcion.setEnabled(false);
        textMonto.setEnabled(false);
        textMaxPersonas.setEnabled(false);
        comboTipoEvento.setEnabled(false);
        comboTipoDeporte.setEnabled(false);
        comboTipoMusica.setEnabled(false);
        textEquipo1.setEnabled(false);
        textEquipo2.setEnabled(false);
        dateChooser.setEnabled(false);
        textJugadoresEq1.setEnabled(false);
        textJugadoresEq2.setEnabled(false);
        textIntegrantes.setEnabled(false);
        textPersonasConvertidas.setEnabled(false);
        textTituloEvento.setEnabled(false);
        textCancelado.setEnabled(false);
    }
}
