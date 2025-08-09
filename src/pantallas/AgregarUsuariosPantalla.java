/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantallas;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import login.Gestion;

/**
 *
 * @author hnleo
 */
public class AgregarUsuariosPantalla extends JFrame {
    private Gestion gestion;
    
    public AgregarUsuariosPantalla(){
        gestion = Gestion.getInstancia();
        pantalla();
    }
    
   private void pantalla() {
    JPanel panelPrincipal = new JPanel();
    JLabel labelTitulo = new JLabel("JAVA EVENTS", SwingConstants.CENTER);
    JLabel labelSubtitulo = new JLabel("Administración de Usuarios.", SwingConstants.CENTER);

    JLabel labelNombre = new JLabel("Nombre Completo:");
    JLabel labelUsuario = new JLabel("Usuario:");
    JLabel labelContraseña = new JLabel("Contraseña:");
    JLabel labelEdad = new JLabel("Edad:");

    JTextField textNombre = new JTextField();
    JTextField usuarioText = new JTextField();
    JTextField contrasennaText = new JTextField();
    JTextField edadText = new JTextField();

    JButton crearUsuarioButton = new JButton("Crear");
    JButton cancelarUsuarioButton = new JButton("Cancelar");
    JButton regresarButton = new JButton("Regresar");

  
    this.setSize(500, 500);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    this.setLayout(null);
    this.setLocationRelativeTo(null);
    this.setTitle("JAVA EVENTS");

    
    panelPrincipal.setBounds(0, 0, 500, 500);
    panelPrincipal.setBackground(Color.WHITE);
    panelPrincipal.setLayout(null);

    
    labelTitulo.setBounds(0, 20, 500, 40);
    labelTitulo.setFont(new Font("Verdana", Font.BOLD, 24));
    labelTitulo.setForeground(Color.BLACK);

    labelSubtitulo.setBounds(0, 60, 500, 20);
    labelSubtitulo.setFont(new Font("Verdana", Font.PLAIN, 14));
    labelSubtitulo.setForeground(Color.BLACK);

  
    int labelWidth = 150;
    int labelHeight = 25;
    int fieldWidth = 200;
    int fieldHeight = 25;
    int startXLabel = 50;
    int startXField = 200;
    int startY = 100;
    int spacingY = 40;

    labelNombre.setBounds(startXLabel, startY, labelWidth, labelHeight);
    textNombre.setBounds(startXField, startY, fieldWidth, fieldHeight);

    labelUsuario.setBounds(startXLabel, startY + spacingY, labelWidth, labelHeight);
    usuarioText.setBounds(startXField, startY + spacingY, fieldWidth, fieldHeight);

    labelContraseña.setBounds(startXLabel, startY + spacingY * 2, labelWidth, labelHeight);
    contrasennaText.setBounds(startXField, startY + spacingY * 2, fieldWidth, fieldHeight);

    labelEdad.setBounds(startXLabel, startY + spacingY * 3, labelWidth, labelHeight);
    edadText.setBounds(startXField, startY + spacingY * 3, fieldWidth, fieldHeight);

    int btnWidth = 120;
    int btnHeight = 30;
    int centerX = (500 - btnWidth) / 2;
    int btnStartY = startY + spacingY * 5;

    crearUsuarioButton.setBounds(centerX, btnStartY, btnWidth, btnHeight);
    cancelarUsuarioButton.setBounds(centerX, btnStartY + (btnHeight + 10), btnWidth, btnHeight);
    regresarButton.setBounds(centerX, btnStartY + 2 * (btnHeight + 10), btnWidth, btnHeight);

    regresarButton.addActionListener(e -> {
        new GestionUsuariosPantalla().setVisible(true);
        this.dispose();
    });

   
    this.add(panelPrincipal);
    panelPrincipal.add(labelTitulo);
    panelPrincipal.add(labelSubtitulo);
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
    }
}
