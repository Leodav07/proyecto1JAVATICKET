/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantallas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import login.Gestion;
/**
 *
 * @author hnleo
 */
public class loginVentana extends JFrame {

    private Gestion gestion;

    public loginVentana() {
        gestion = Gestion.getInstancia();
        cargarComponentes();
    }

    private void cargarComponentes() {
        JPanel panelLogin = new JPanel();
        JLabel labelLogin = new JLabel("INICIO DE SESIÓN");
        JLabel labelUser = new JLabel("Usuario:");
        JLabel labelPass = new JLabel("Contraseña:");
        JTextField tusuario = new JTextField();
        JPasswordField tpassword = new JPasswordField();
        JButton iniciarButton = new JButton("Entrar");
        JButton salirButton = new JButton("Salir");

        this.setSize(420, 380);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Inicio de Sesión");

        panelLogin.setBounds(0, 0, 420, 380);
        panelLogin.setBackground(new Color(245, 247, 250)); 
        panelLogin.setLayout(null);

        labelLogin.setBounds(100, 20, 250, 40);
        labelLogin.setFont(new Font("Segoe UI", Font.BOLD, 22));
        labelLogin.setForeground(new Color(50, 50, 50));

        labelUser.setBounds(60, 100, 100, 25);
        labelUser.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        labelUser.setForeground(new Color(70, 70, 70));

        labelPass.setBounds(60, 150, 100, 25);
        labelPass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        labelPass.setForeground(new Color(70, 70, 70));

        tusuario.setBounds(160, 100, 180, 28);
        tusuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tusuario.setForeground(Color.DARK_GRAY);
        tusuario.setBackground(Color.WHITE);
        tusuario.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true),
                javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        tpassword.setBounds(160, 150, 180, 28);
        tpassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tpassword.setForeground(Color.DARK_GRAY);
        tpassword.setBackground(Color.WHITE);
        tpassword.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true),
                javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        iniciarButton.setBounds(90, 220, 120, 35);
        iniciarButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        iniciarButton.setForeground(Color.WHITE);
        iniciarButton.setBackground(new Color(93, 173, 226));
        iniciarButton.setFocusPainted(false);
        iniciarButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 20, 8, 20));
        iniciarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        iniciarButton.addActionListener(e -> {
            try {
                String password = new String(tpassword.getPassword());
                if (gestion.loginCuenta(tusuario.getText(), password)) {
                    new pantallaPrincipal().setVisible(true);
                    System.out.println("Bienvenido: " + gestion.buscarUsuarios(tusuario.getText(), 0).getNombreCompleto());
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecta.", "Error de inicio", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception errorInicio) {
                JOptionPane.showMessageDialog(this, errorInicio.getMessage());
            }
        });

        salirButton.setBounds(230, 220, 120, 35);
        salirButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        salirButton.setForeground(Color.WHITE);
        salirButton.setBackground(new Color(220, 53, 69));
        salirButton.setFocusPainted(false);
        salirButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 20, 8, 20));
        salirButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        salirButton.addActionListener(e -> System.exit(0));

        this.add(panelLogin);
        panelLogin.add(labelLogin);
        panelLogin.add(labelUser);
        panelLogin.add(labelPass);
        panelLogin.add(tusuario);
        panelLogin.add(tpassword);
        panelLogin.add(iniciarButton);
        panelLogin.add(salirButton);
    }
}
