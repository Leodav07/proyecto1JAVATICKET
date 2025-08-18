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
public class pantallaPrincipal extends JFrame {

    private Gestion gestion;

    public pantallaPrincipal() {
        verificarUser();
        gestion = Gestion.getInstancia();
    }

    private void aplicarEstiloPanel(JPanel panel) {
        panel.setBackground(new Color(245, 245, 245));
        panel.setLayout(null);
    }

    private JButton crearBoton(String texto, int x, int y, int width, int height) {
        JButton boton = new JButton(texto);
        boton.setBounds(x, y, width, height);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        boton.setForeground(Color.WHITE);
        boton.setBackground(new Color(0, 123, 255));
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder());
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setOpaque(true);
        boton.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        return boton;
    }

    private JLabel crearTitulo(String texto, int y) {
        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setBounds(0, y, 800, 40);
        label.setFont(new Font("Segoe UI", Font.BOLD, 30));
        label.setForeground(new Color(33, 33, 33));
        return label;
    }

    private JLabel crearSubtitulo(String texto, int y) {
        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setBounds(0, y, 800, 25);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        label.setForeground(new Color(100, 100, 100));
        return label;
    }

    private void pantallaAdmin() {
        JPanel panelPrincipal = new JPanel();
        aplicarEstiloPanel(panelPrincipal);

        JLabel labelTitulo = crearTitulo("JAVA EVENTS", 50);
        JLabel labelSubtitulo = crearSubtitulo("Maneja perfectamente tus eventos.", 100);

        JButton adminEventButton = crearBoton("Administrar Eventos", 300, 160, 200, 40);
        adminEventButton.addActionListener(e -> {
            new GestionEventosPantalla().setVisible(true);
            this.dispose();
        });

        JButton adminUserButton = crearBoton("Administrar Usuarios", 300, 220, 200, 40);
        adminUserButton.addActionListener(e -> {
            new GestionUsuariosPantalla().setVisible(true);
            this.dispose();
        });

        JButton reportesButton = crearBoton("Listado de Reportes", 300, 280, 200, 40);
        reportesButton.addActionListener(e -> {
            new GestionReportesPantalla().setVisible(true);
            this.dispose();
        });

        JButton cerrarSesionButton = crearBoton("Cerrar Sesión", 300, 340, 200, 40);
        cerrarSesionButton.setBackground(new Color(220, 53, 69)); // rojo

        cerrarSesionButton.addActionListener(e -> {
            int op = JOptionPane.showConfirmDialog(this, "¿Seguro deseas cerrar sesión?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (op == JOptionPane.YES_OPTION) {
                cerrarSesionUser();

            } else if (op == JOptionPane.NO_OPTION) {

            }

        });

        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("JAVA EVENTS");
        this.setVisible(true);

        this.add(panelPrincipal);
        panelPrincipal.add(labelTitulo);
        panelPrincipal.add(labelSubtitulo);
        panelPrincipal.add(adminEventButton);
        panelPrincipal.add(adminUserButton);
        panelPrincipal.add(reportesButton);
        panelPrincipal.add(cerrarSesionButton);
    }

    private void pantallaContenido() {
        JPanel panelPrincipal = new JPanel();
        aplicarEstiloPanel(panelPrincipal);

        JLabel labelTitulo = crearTitulo("JAVA EVENTS", 50);
        JLabel labelSubtitulo = crearSubtitulo("Maneja perfectamente tus eventos.", 100);

        JButton adminEventButton = crearBoton("Administrar Eventos", 300, 160, 200, 40);
        adminEventButton.addActionListener(e -> {
            new GestionEventosPantalla().setVisible(true);
            this.dispose();
        });

        JButton reportesButton = crearBoton("Listado de Reportes", 300, 220, 200, 40);
        reportesButton.addActionListener(e -> {
            new GestionReportesPantalla().setVisible(true);
            this.dispose();
        });

        JButton cerrarSesionButton = crearBoton("Cerrar Sesión", 300, 280, 200, 40);
        cerrarSesionButton.setBackground(new Color(220, 53, 69));
         cerrarSesionButton.addActionListener(e -> {
            int op = JOptionPane.showConfirmDialog(this, "¿Seguro deseas cerrar sesión?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (op == JOptionPane.YES_OPTION) {
                cerrarSesionUser();

            } else if (op == JOptionPane.NO_OPTION) {

            }

        });

        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("JAVA EVENTS");
        this.setVisible(true);

        this.add(panelPrincipal);
        panelPrincipal.add(labelTitulo);
        panelPrincipal.add(labelSubtitulo);
        panelPrincipal.add(adminEventButton);
        panelPrincipal.add(reportesButton);
        panelPrincipal.add(cerrarSesionButton);
    }

    private void pantallaLimitada() {
        JPanel panelPrincipal = new JPanel();
        aplicarEstiloPanel(panelPrincipal);

        JLabel labelTitulo = crearTitulo("JAVA EVENTS", 50);
        JLabel labelSubtitulo = crearSubtitulo("Maneja perfectamente tus eventos.", 100);

        JButton verEventosButton = crearBoton("Ver Eventos", 300, 160, 200, 40);
        verEventosButton.addActionListener(e -> {
            new VerEventoPantalla().setVisible(true);
            this.dispose();
        });

        JButton reportesButton = crearBoton("Listado de Reportes", 300, 220, 200, 40);
        reportesButton.addActionListener(e -> {
            new GestionReportesPantalla().setVisible(true);
            this.dispose();
        });

        JButton cerrarSesionButton = crearBoton("Cerrar Sesión", 300, 280, 200, 40);
        cerrarSesionButton.setBackground(new Color(220, 53, 69));
        cerrarSesionButton.addActionListener(e -> {
            int op = JOptionPane.showConfirmDialog(this, "¿Seguro deseas cerrar sesión?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (op == JOptionPane.YES_OPTION) {
                cerrarSesionUser();

            } else if (op == JOptionPane.NO_OPTION) {

            }

        });

        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("JAVA EVENTS");
        this.setVisible(true);

        this.add(panelPrincipal);
        panelPrincipal.add(labelTitulo);
        panelPrincipal.add(labelSubtitulo);
        panelPrincipal.add(verEventosButton);
        panelPrincipal.add(reportesButton);
        panelPrincipal.add(cerrarSesionButton);
    }

    private void verificarUser() {
        try {
            if (gestion.usuarioActual.getTipoRol().equals("ADMIN")) {
                pantallaAdmin();
            } else if (gestion.usuarioActual.getTipoRol().equals("CONTENIDO")) {
                pantallaContenido();
            } else if (gestion.usuarioActual.getTipoRol().equals("LIMITADO")) {
                pantallaLimitada();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void cerrarSesionUser() {
        try {
            if (gestion.usuarioActual != null) {
                gestion.usuarioActual = null;
                new loginVentana().setVisible(true);
                this.dispose();
            }
        } catch (Exception i) {
            System.out.println(i.getMessage());
        }
    }
}
