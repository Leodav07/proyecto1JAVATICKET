/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantallas;

import events.EventoDeportivo;
import events.EventoMusical;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import login.Gestion;
import java.util.Calendar;
import com.toedter.calendar.JDateChooser;
import events.TipoDeporte;
import events.TipoMusica;
import java.util.Date;

/**
 *
 * @author hnleo
 */
public class CrearEventosPantalla extends JFrame {

    private JLabel labelTipoEvento, labelCodigo, labelTituloEvento, labelDescripcion, labelFecha, labelMonto, labelMaxPersonas;
    private JLabel labelEquipo1, labelEquipo2, labelTipoDeporte, labelTipoMusica;
    private JTextField textCodigo, textTituloEvento, textDescripcion, textMonto, textMaxPersonas;
    private JDateChooser dateChooser = new JDateChooser();
    private JTextField textEquipo1, textEquipo2;
    private JComboBox<String> comboTipoEvento;
    private JComboBox<TipoDeporte> comboTipoDeporte;
    private JComboBox<TipoMusica> comboTipoMusica;
    private JButton crearEventoButton, cancelarButton, regresarButton;

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

    public CrearEventosPantalla() {
        pantalla();
        configurarVentana();
        agregarComponentes();
        agregarEventos();
        ajustarCamposSegunTipo("DEPORTIVO");
        gestion = Gestion.getInstancia();
    }

    private void pantalla() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.WHITE);

        JLabel labelTitulo = new JLabel("JAVA EVENTS", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Verdana", Font.BOLD, 24));
        labelTitulo.setBounds(0, 20, 550, 40);
        panelPrincipal.add(labelTitulo);

        JLabel labelSubtitulo = new JLabel("Creación de Evento", SwingConstants.CENTER);
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

        labelTipoDeporte = new JLabel("Tipo de Deporte:");
        comboTipoDeporte = new JComboBox<>(TipoDeporte.values());

        labelTipoMusica = new JLabel("Tipo de Música:");
        comboTipoMusica = new JComboBox<>(TipoMusica.values());

        crearEventoButton = new JButton("Crear");
        cancelarButton = new JButton("Cancelar");
        regresarButton = new JButton("Regresar");
    }

    private void configurarVentana() {
        this.setSize(550, 700);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("JAVA EVENTS");
        this.add(panelPrincipal);
        panelPrincipal.setBounds(0, 0, 550, 700);
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

        crearEventoButton.setBounds(startXLabel, y + 6 * spacingY, btnWidth, btnHeight);
        cancelarButton.setBounds(startXField, y + 6 * spacingY, btnWidth, btnHeight);
        regresarButton.setBounds((550 - btnWidth) / 2, y + 6 * spacingY + btnHeight + 10, btnWidth, btnHeight);

        panelPrincipal.add(crearEventoButton);
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

        //Verificar que el evento exista o no
        try {
            textCodigo.addFocusListener(new FocusAdapter() {

                @Override

                public void focusLost(FocusEvent e) {
                    int codigoEvento = 0;
                    try {
                        codigoEvento = Integer.parseInt(textCodigo.getText());
                    } catch (NumberFormatException u) {
                        System.out.println("");
                    }

                    if (gestion.buscarEventos(codigoEvento, 0) != null || textCodigo.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(CrearEventosPantalla.this, "Codigo de Evento ya existe o campo vacio.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        crearEventoButton.setEnabled(false);
                        textCodigo.setText("");
                        textCodigo.requestFocus();

                    } else {

                        crearEventoButton.setEnabled(true);
                    }
                }
            });

        } catch (Exception e) {
            JOptionPane.showMessageDialog(CrearEventosPantalla.this, "Ocurrio un error." + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }

        crearEventoButton.addActionListener(e -> {
            try {
                int codigoEvento = Integer.parseInt(textCodigo.getText());
                double montoRenta = Double.parseDouble(textMonto.getText());
                int cantidadPersonas = Integer.parseInt(textMaxPersonas.getText());
                if (comboTipoEvento.getSelectedItem().toString().equals("DEPORTIVO")) {
                    if (cantidadPersonas > 20000) {
                        JOptionPane.showMessageDialog(this, "Cantidad de personas máxima permitida para eventos deportivos: 20,000", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                       return;

                    }
                } else if (comboTipoEvento.getSelectedItem().toString().equals("MUSICAL")) {
                    if (cantidadPersonas > 25000) {
                        JOptionPane.showMessageDialog(this, "Cantidad de personas máxima permitida para eventos musicales: 25,000", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                     return;

                    }
                } else if (comboTipoEvento.getSelectedItem().toString().equals("RELIGIOSO")) {
                    if (cantidadPersonas > 30000) {
                        JOptionPane.showMessageDialog(this, "Cantidad de personas máxima permitida para eventos religiosos: 30,000", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                       return;
                    }
                }
                JOptionPane.showMessageDialog(this, gestion.crearEvento(codigoEvento, textTituloEvento.getText(), textDescripcion.getText(), dateChooser.getCalendar(), montoRenta, comboTipoEvento.getSelectedItem().toString(), textEquipo1.getText(), textEquipo2.getText(), comboTipoDeporte.getSelectedItem().toString(), comboTipoMusica.getSelectedItem().toString(), cantidadPersonas), "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
              
            } catch (Exception i) {
                JOptionPane.showMessageDialog(this, "Ocurrio un error: Textos de numeros no convertidos a String." + i.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        cancelarButton.addActionListener(e->{
           limpiarCampos();
           textCodigo.requestFocus();
        });

    }
    
    private void limpiarCampos(){
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

        int y = startY + 6 * spacingY;

        if (tipoEvento.equals("DEPORTIVO")) {
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

        } else if (tipoEvento.equals("MUSICAL")) {
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

        } else if (tipoEvento.equals("RELIGIOSO")) {
            labelMaxPersonas.setBounds(startXLabel, y, labelWidth, labelHeight);
            textMaxPersonas.setBounds(startXField, y, fieldWidth, fieldHeight);

            panelPrincipal.add(labelMaxPersonas);
            panelPrincipal.add(textMaxPersonas);
            labelMaxPersonas.setText("Cantidad de pers. (Max. 30,000):");
            y += spacingY;
        }

        crearEventoButton.setBounds(startXLabel, y + 10, btnWidth, btnHeight);
        cancelarButton.setBounds(startXField, y + 10, btnWidth, btnHeight);
        regresarButton.setBounds((550 - btnWidth) / 2, y + 10 + btnHeight + 10, btnWidth, btnHeight);

        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

}
