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
public class GestionUsuariosPantalla extends JFrame {
    private Gestion gestion;

    public GestionUsuariosPantalla() {
        gestion = Gestion.getInstancia();
        pantalla();
    }

    private void aplicarEstiloPanel(JPanel panel) {
        panel.setBackground(new Color(245, 245, 245));
        panel.setLayout(null);
    }

    private JButton crearBoton(String texto, int x, int y, int width, int height, Color color) {
        JButton boton = new JButton(texto);
        boton.setBounds(x, y, width, height);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        boton.setForeground(Color.WHITE);
        boton.setBackground(color);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder());
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setOpaque(true);
        boton.setUI(new javax.swing.plaf.basic.BasicButtonUI()); 
        return boton;
    }

    private JLabel crearTitulo(String texto, int y) {
        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setBounds(0, y, 800, 50);
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

    private void pantalla() {
        JPanel panelPrincipal = new JPanel();
        aplicarEstiloPanel(panelPrincipal);

        JLabel labelTitulo = crearTitulo("JAVA EVENTS", 40);
        JLabel labelSubtitulo = crearSubtitulo("Administración de Usuarios.", 100);

        int btnWidth = 220;
        int btnHeight = 40;
        int centerX = (800 - btnWidth) / 2;
        int startY = 180;
        int spacing = 15;

        JButton crearUsuarioButton = crearBoton("Crear Usuarios", centerX, startY, btnWidth, btnHeight, new Color(0, 123, 255));
        crearUsuarioButton.addActionListener(e -> {
            new AgregarUsuariosPantalla().setVisible(true);
            this.dispose();
        });

        JButton editarUsuarioButton = crearBoton("Editar Usuarios", centerX, startY + (btnHeight + spacing), btnWidth, btnHeight, new Color(0, 123, 255));
        editarUsuarioButton.addActionListener(e -> {
            new EditarUsuariosPantalla().setVisible(true);
            this.dispose();
        });

        JButton eliminarUsuarioButton = crearBoton("Eliminar Usuarios", centerX, startY + 2 * (btnHeight + spacing), btnWidth, btnHeight, new Color(0, 123, 255));
        eliminarUsuarioButton.addActionListener(e -> {
            new BorrarUsuariosPantalla().setVisible(true);
            this.dispose();
        });

        JButton regresarButton = crearBoton("Regresar", centerX, startY + 3 * (btnHeight + spacing), btnWidth, btnHeight, new Color(220, 53, 69));
        regresarButton.addActionListener(e -> {
            new pantallaPrincipal().setVisible(true);
            this.dispose();
        });

        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("JAVA EVENTS");
        this.setVisible(true);

        this.add(panelPrincipal);
        panelPrincipal.add(labelTitulo);
        panelPrincipal.add(labelSubtitulo);
        panelPrincipal.add(crearUsuarioButton);
        panelPrincipal.add(editarUsuarioButton);
        panelPrincipal.add(eliminarUsuarioButton);
        panelPrincipal.add(regresarButton);
    }
}
