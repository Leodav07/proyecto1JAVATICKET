/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantallas;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.*;
import login.Gestion;
/**
 *
 * @author hnleo
 */
public class AgregarUsuariosPantalla extends JFrame {

    private Gestion gestion;
    private boolean pasar;

    public AgregarUsuariosPantalla() {
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
        return boton;
    }

    private JLabel crearTitulo(String texto, int size) {
        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, size));
        label.setForeground(new Color(33, 33, 33));
        return label;
    }

    private JLabel crearSubtitulo(String texto, int size) {
        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.PLAIN, size));
        label.setForeground(new Color(100, 100, 100));
        return label;
    }

    private void pantalla() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(new Color(245, 245, 245));
        panelPrincipal.setLayout(null);

        JLabel labelTitulo = crearTitulo("JAVA EVENTS", 24);
        JLabel labelSubtitulo = crearSubtitulo("Administración de Usuarios", 16);

        labelTitulo.setBounds(0, 20, 500, 30);
        labelSubtitulo.setBounds(0, 55, 500, 20);

        JLabel labelTipoUsuario = new JLabel("Tipo de Usuario:");
        JComboBox<String> comboTipoUsuario = new JComboBox<>(new String[]{"ADMINISTRADOR", "CONTENIDO", "LIMITADO"});
        JLabel labelNombre = new JLabel("Nombre Completo:");
        JLabel labelUsuario = new JLabel("Usuario:");
        JLabel labelContraseña = new JLabel("Contraseña:");
        JLabel labelEdad = new JLabel("Edad:");

        JTextField textNombre = new JTextField();
        JTextField usuarioText = new JTextField();
        JTextField contrasennaText = new JTextField();
        JTextField edadText = new JTextField();

        int labelX = 30, fieldX = 180, startY = 100, spacingY = 45, labelWidth = 140, fieldWidth = 250, fieldHeight = 25;
        labelTipoUsuario.setBounds(labelX, startY, labelWidth, fieldHeight);
        comboTipoUsuario.setBounds(fieldX, startY, fieldWidth, fieldHeight);

        labelNombre.setBounds(labelX, startY + spacingY, labelWidth, fieldHeight);
        textNombre.setBounds(fieldX, startY + spacingY, fieldWidth, fieldHeight);

        labelUsuario.setBounds(labelX, startY + 2 * spacingY, labelWidth, fieldHeight);
        usuarioText.setBounds(fieldX, startY + 2 * spacingY, fieldWidth, fieldHeight);

        labelContraseña.setBounds(labelX, startY + 3 * spacingY, labelWidth, fieldHeight);
        contrasennaText.setBounds(fieldX, startY + 3 * spacingY, fieldWidth, fieldHeight);

        labelEdad.setBounds(labelX, startY + 4 * spacingY, labelWidth, fieldHeight);
        edadText.setBounds(fieldX, startY + 4 * spacingY, fieldWidth, fieldHeight);

        JButton crearUsuarioButton = crearBoton("Crear", new Color(0, 123, 255));
        JButton cancelarUsuarioButton = crearBoton("Cancelar", new Color(108, 117, 125));
        JButton regresarButton = crearBoton("Regresar", new Color(220, 53, 69));

        int btnY = startY + 5 * spacingY + 10;
        crearUsuarioButton.setBounds(labelX, btnY, 120, 35);
        cancelarUsuarioButton.setBounds(fieldX, btnY, 120, 35);
        regresarButton.setBounds((500 - 120)/2, btnY + 50, 120, 35);

        usuarioText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (gestion.buscarUsuarios(usuarioText.getText(), 0) != null || usuarioText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(AgregarUsuariosPantalla.this, "Usuario ya existe o campo vacío.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    crearUsuarioButton.setEnabled(false);
                    usuarioText.setText("");
                    usuarioText.requestFocus();
                    pasar = false;
                } else {
                    pasar = true;
                    crearUsuarioButton.setEnabled(true);
                }
            }
        });

        contrasennaText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (pasar) {
                    if (!gestion.verificarContraseña(contrasennaText.getText())) {
                        JOptionPane.showMessageDialog(
                                AgregarUsuariosPantalla.this,
                                gestion.mensajeDeContraseña(contrasennaText.getText()),
                                "ADVERTENCIA",
                                JOptionPane.WARNING_MESSAGE
                        );
                        crearUsuarioButton.setEnabled(false);
                        contrasennaText.requestFocus();
                    } else {
                        crearUsuarioButton.setEnabled(true);
                    }
                }
            }
        });

        // Acciones botones
        crearUsuarioButton.addActionListener(e -> {
            try {
                int edad = Integer.parseInt(edadText.getText());
                JOptionPane.showMessageDialog(this,
                        gestion.agregarUsuarios(usuarioText.getText(), contrasennaText.getText(),
                                comboTipoUsuario.getSelectedItem().toString(), textNombre.getText(), edad),
                        "AVISO", JOptionPane.INFORMATION_MESSAGE);
                textNombre.setText("");
                usuarioText.setText("");
                contrasennaText.setText("");
                edadText.setText("");
            } catch (NumberFormatException o) {
                JOptionPane.showMessageDialog(this, "El valor de la edad debe ser numérico.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelarUsuarioButton.addActionListener(e -> {
            textNombre.setText("");
            usuarioText.setText("");
            contrasennaText.setText("");
            edadText.setText("");
        });

        regresarButton.addActionListener(e -> {
            new GestionUsuariosPantalla().setVisible(true);
            this.dispose();
        });

        panelPrincipal.add(labelTitulo);
        panelPrincipal.add(labelSubtitulo);
        panelPrincipal.add(labelTipoUsuario);
        panelPrincipal.add(comboTipoUsuario);
        panelPrincipal.add(labelNombre);
        panelPrincipal.add(textNombre);
        panelPrincipal.add(labelUsuario);
        panelPrincipal.add(usuarioText);
        panelPrincipal.add(labelContraseña);
        panelPrincipal.add(contrasennaText);
        panelPrincipal.add(labelEdad);
        panelPrincipal.add(edadText);
        panelPrincipal.add(crearUsuarioButton);
        panelPrincipal.add(cancelarUsuarioButton);
        panelPrincipal.add(regresarButton);

        this.add(panelPrincipal);
        this.setSize(500, 500);
        this.setTitle("JAVA EVENTS");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }
}
