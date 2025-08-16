/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
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

    private void pantalla() {
        setTitle("JAVA EVENTS");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
        panelSuperior.setBackground(Color.WHITE);

        JLabel titulo = new JLabel("JAVA EVENTS", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel("Reportes de Eventos", SwingConstants.CENTER);
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 20));
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelSuperior.add(Box.createVerticalStrut(20));
        panelSuperior.add(titulo);
        panelSuperior.add(Box.createVerticalStrut(10));
        panelSuperior.add(subtitulo);
        panelSuperior.add(Box.createVerticalStrut(30));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBackground(Color.WHITE);

        btnEventosRealizados = new JButton("Eventos realizados");
        btnEventosFuturos = new JButton("Eventos futuros");
        btnEventosCancelados = new JButton("Eventos cancelados");
        btnIngresos = new JButton("Ingresos generados (Fecha)");
        btnVerPerfil = new JButton("Ver perfil");
        btnRegresar = new JButton("Regresar");

        JButton[] botones = {
            btnEventosRealizados, btnEventosFuturos, btnEventosCancelados,
            btnIngresos, btnVerPerfil, btnRegresar
        };

        for (JButton boton : botones) {
            boton.setAlignmentX(Component.CENTER_ALIGNMENT);
            boton.setMaximumSize(new Dimension(250, 40));
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
        });

        btnEventosCancelados.addActionListener(e -> {
        });

        btnIngresos.addActionListener(e -> {
        });

        btnVerPerfil.addActionListener(e -> {
        });

        btnRegresar.addActionListener(e -> {
            new pantallaPrincipal().setVisible(true);
            this.dispose();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestionReportesPantalla ventana = new GestionReportesPantalla();
            ventana.setVisible(true);
        });
    }
}
