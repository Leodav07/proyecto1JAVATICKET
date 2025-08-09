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
import javax.swing.SwingConstants;
import login.Gestion;

/**
 *
 * @author hnleo
 */
public class GestionUsuariosPantalla extends JFrame {
    private Gestion gestion;
    
    public GestionUsuariosPantalla(){
        gestion = Gestion.getInstancia();
        pantalla();
    }
    
    private void pantalla() {
    JPanel panelPrincipal = new JPanel();
    JLabel labelTitulo = new JLabel("JAVA EVENTS", SwingConstants.CENTER);
    JLabel labelSubtitulo = new JLabel("Administración de Usuarios.", SwingConstants.CENTER);
    JButton crearUsuarioButton = new JButton("Crear Usuarios");
    JButton editarUsuarioButton = new JButton("Editar Usuarios");
    JButton eliminarUsuarioButton = new JButton("Eliminar Usuarios");
    JButton regresarButton = new JButton("Regresar");

    this.setSize(800, 600);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    this.setLayout(null);
    this.setLocationRelativeTo(null);
    this.setTitle("JAVA EVENTS");

    panelPrincipal.setBounds(0, 0, 800, 600);
    panelPrincipal.setBackground(Color.WHITE);
    panelPrincipal.setLayout(null);

    labelTitulo.setBounds(0, 40, 800, 50);
    labelTitulo.setFont(new Font("Verdana", Font.BOLD, 28));
    labelTitulo.setForeground(Color.BLACK);

   
    labelSubtitulo.setBounds(0, 90, 800, 25);
    labelSubtitulo.setFont(new Font("Verdana", Font.PLAIN, 16));
    labelSubtitulo.setForeground(Color.BLACK);

    
    int btnWidth = 220;
    int btnHeight = 40;
    int centerX = (800 - btnWidth) / 2;
    int startY = 180;
    int spacing = 15;

    crearUsuarioButton.setBounds(centerX, startY, btnWidth, btnHeight);
    crearUsuarioButton.setFont(new Font("Verdana", Font.BOLD, 14));
    crearUsuarioButton.addActionListener(e->{
       new AgregarUsuariosPantalla().setVisible(true); 
       this.dispose();
    });

    editarUsuarioButton.setBounds(centerX, startY + (btnHeight + spacing), btnWidth, btnHeight);
    editarUsuarioButton.setFont(new Font("Verdana", Font.BOLD, 14));
    editarUsuarioButton.addActionListener(e->{
       new EditarUsuariosPantalla().setVisible(true);
       this.dispose();
    });
    eliminarUsuarioButton.setBounds(centerX, startY + 2 * (btnHeight + spacing), btnWidth, btnHeight);
    eliminarUsuarioButton.setFont(new Font("Verdana", Font.BOLD, 14));
    eliminarUsuarioButton.addActionListener(e->{
       new BorrarUsuariosPantalla().setVisible(true);
       this.dispose();
    });
    regresarButton.setBounds(centerX, startY + 3 * (btnHeight + spacing), btnWidth, btnHeight);
    regresarButton.setFont(new Font("Verdana", Font.BOLD, 14));

    regresarButton.addActionListener(e -> {
        new pantallaPrincipal().setVisible(true);
        this.dispose();
        
    });

    this.add(panelPrincipal);
    panelPrincipal.add(labelTitulo);
    panelPrincipal.add(labelSubtitulo);
    panelPrincipal.add(crearUsuarioButton);
    panelPrincipal.add(editarUsuarioButton);
    panelPrincipal.add(eliminarUsuarioButton);
    panelPrincipal.add(regresarButton);
}
}
