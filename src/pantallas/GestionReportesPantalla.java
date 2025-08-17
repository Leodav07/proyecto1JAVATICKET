/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantallas;

import java.awt.*;
import javax.swing.*;
import login.Gestion;
/**
 *
 * @author hnleo
 */
public class GestionReportesPantalla extends JFrame {

    private JButton btnEventosRealizados, btnEventosFuturos, btnEventosCancelados, btnIngresos, btnVerPerfil, btnRegresar;
    private Gestion gestion;

    public GestionReportesPantalla() {
        gestion = Gestion.getInstancia();
        pantalla();
    }

    private JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        boton.setForeground(Color.WHITE);
        boton.setBackground(color);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder());
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setOpaque(true);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setMaximumSize(new Dimension(250, 40));
        return boton;
    }

    private JLabel crearTitulo(String texto, int size) {
        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, size));
        label.setForeground(new Color(33, 33, 33));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    private JLabel crearSubtitulo(String texto, int size) {
        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.PLAIN, size));
        label.setForeground(new Color(100, 100, 100));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    private void pantalla() {
        setTitle("JAVA EVENTS");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(new Color(245, 245, 245));
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));

        JLabel titulo = crearTitulo("JAVA EVENTS", 28);
        JLabel subtitulo = crearSubtitulo("Reportes de Eventos", 18);

        panelSuperior.add(Box.createVerticalStrut(20));
        panelSuperior.add(titulo);
        panelSuperior.add(Box.createVerticalStrut(10));
        panelSuperior.add(subtitulo);
        panelSuperior.add(Box.createVerticalStrut(30));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBackground(new Color(245, 245, 245));

        btnEventosRealizados = crearBoton("Eventos realizados", new Color(0, 123, 255));
        btnEventosFuturos = crearBoton("Eventos futuros", new Color(0, 123, 255));
        btnEventosCancelados = crearBoton("Eventos cancelados", new Color(0, 123, 255));
        btnIngresos = crearBoton("Ingresos generados (Fecha)", new Color(0, 123, 255));
        btnVerPerfil = crearBoton("Ver perfil", new Color(0, 123, 255));
        btnRegresar = crearBoton("Regresar", new Color(220, 53, 69));

        JButton[] botones = {
            btnEventosRealizados, btnEventosFuturos, btnEventosCancelados,
            btnIngresos, btnVerPerfil, btnRegresar
        };

        for (JButton boton : botones) {
            panelBotones.add(boton);
            panelBotones.add(Box.createVerticalStrut(15));
        }

        add(panelSuperior, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);

        btnEventosRealizados.addActionListener(e -> {
            new EventosRealizadosPantalla().setVisible(true);
            this.dispose();
        });

        btnEventosFuturos.addActionListener(e -> {
            new EventosFuturosPantalla().setVisible(true);
            this.dispose();
        });

        btnEventosCancelados.addActionListener(e -> {
            new EventosCanceladosPantalla().setVisible(true);
            this.dispose();
        });

        btnIngresos.addActionListener(e -> {
            new EventosPorRangoPantalla().setVisible(true);
            this.dispose();
        });

        btnVerPerfil.addActionListener(e -> {
            new VerPerfilPantalla().setVisible(true);
            this.dispose();
        });

        btnRegresar.addActionListener(e -> {
            new pantallaPrincipal().setVisible(true);
            this.dispose();
        });
    }
}
