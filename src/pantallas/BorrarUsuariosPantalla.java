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
import login.Usuario;
/**
 *
 * @author hnleo
 */
public class BorrarUsuariosPantalla extends JFrame {

    private Gestion gestion;

    public BorrarUsuariosPantalla() {
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
        labelUsuario.setBounds(labelX, startY, labelWidth, fieldHeight);
        usuarioText.setBounds(fieldX, startY, fieldWidth, fieldHeight);

        labelNombre.setBounds(labelX, startY + spacingY, labelWidth, fieldHeight);
        textNombre.setBounds(fieldX, startY + spacingY, fieldWidth, fieldHeight);

        labelTipoUsuario.setBounds(labelX, startY + 2 * spacingY, labelWidth, fieldHeight);
        comboTipoUsuario.setBounds(fieldX, startY + 2 * spacingY, fieldWidth, fieldHeight);

        labelContraseña.setBounds(labelX, startY + 3 * spacingY, labelWidth, fieldHeight);
        contrasennaText.setBounds(fieldX, startY + 3 * spacingY, fieldWidth, fieldHeight);

        labelEdad.setBounds(labelX, startY + 4 * spacingY, labelWidth, fieldHeight);
        edadText.setBounds(fieldX, startY + 4 * spacingY, fieldWidth, fieldHeight);

        JButton borrarButton = crearBoton("Borrar", new Color(220, 53, 69));
        JButton cancelarButton = crearBoton("Cancelar", new Color(108, 117, 125));
        JButton regresarButton = crearBoton("Regresar", new Color(0, 123, 255));

        int btnY = startY + 5 * spacingY + 10;
        borrarButton.setBounds(labelX, btnY, 120, 35);
        cancelarButton.setBounds(fieldX, btnY, 120, 35);
        regresarButton.setBounds((500 - 120)/2, btnY + 50, 120, 35);

        usuarioText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                Usuario user = gestion.buscarUsuarios(usuarioText.getText(), 0);
                if (user != null) {
                    textNombre.setText(user.getNombreCompleto());
                    contrasennaText.setText(user.getPass());
                    comboTipoUsuario.setSelectedItem(user.getTipoRol());
                    edadText.setText(String.valueOf(user.getEdad()));
                } else if(!usuarioText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(BorrarUsuariosPantalla.this, "Usuario no existe.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    textNombre.setText("");
                    usuarioText.setText("");
                    contrasennaText.setText("");
                    edadText.setText("");
                    usuarioText.requestFocus();
                }
            }
        });

        borrarButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, gestion.borrarUsuario(usuarioText.getText()), "AVISO", JOptionPane.INFORMATION_MESSAGE);
            textNombre.setText("");
            usuarioText.setText("");
            contrasennaText.setText("");
            edadText.setText("");
            usuarioText.requestFocus();
        });

        cancelarButton.addActionListener(e -> {
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
        panelPrincipal.add(borrarButton);
        panelPrincipal.add(cancelarButton);
        panelPrincipal.add(regresarButton);

        this.add(panelPrincipal);
        this.setSize(500, 500);
        this.setTitle("JAVA EVENTS");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }
}
