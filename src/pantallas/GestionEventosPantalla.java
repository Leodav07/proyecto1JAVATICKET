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
public class GestionEventosPantalla extends JFrame {

    private Gestion gestion;

    public GestionEventosPantalla() {
        gestion = Gestion.getInstancia();
        pantalla();
    }

    private void pantalla() {
        JPanel panelPrincipal = new JPanel();
        JLabel labelTitulo = new JLabel("JAVA EVENTS", SwingConstants.CENTER);
        JLabel labelSubtitulo = new JLabel("Administración de Eventos.", SwingConstants.CENTER);
        JButton crearEventoButton = new JButton("Crear Eventos");
        JButton editarEventoButton = new JButton("Editar Eventos");
        JButton eliminarEventoButton = new JButton("Eliminar Eventos");
        JButton verEventoButton = new JButton("Ver Eventos");
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

        crearEventoButton.setBounds(centerX, startY, btnWidth, btnHeight);
        crearEventoButton.setFont(new Font("Verdana", Font.BOLD, 14));
        crearEventoButton.addActionListener(e->{
           new CrearEventosPantalla().setVisible(true);
           this.dispose();
        });

        editarEventoButton.setBounds(centerX, startY + (btnHeight + spacing), btnWidth, btnHeight);
        editarEventoButton.setFont(new Font("Verdana", Font.BOLD, 14));

        eliminarEventoButton.setBounds(centerX, startY + 2 * (btnHeight + spacing), btnWidth, btnHeight);
        eliminarEventoButton.setFont(new Font("Verdana", Font.BOLD, 14));

        verEventoButton.setBounds(centerX, startY + 3 * (btnHeight + spacing), btnWidth, btnHeight);
        verEventoButton.setFont(new Font("Verdana", Font.BOLD, 14));

        regresarButton.setBounds(centerX, startY + 4 * (btnHeight + spacing), btnWidth, btnHeight);
        regresarButton.setFont(new Font("Verdana", Font.BOLD, 14));
        regresarButton.addActionListener(e->{
            new pantallaPrincipal().setVisible(true);
            this.dispose();
        });

        this.add(panelPrincipal);
        panelPrincipal.add(labelTitulo);
        panelPrincipal.add(labelSubtitulo);
        panelPrincipal.add(crearEventoButton);
        panelPrincipal.add(editarEventoButton);
        panelPrincipal.add(eliminarEventoButton);
        panelPrincipal.add(verEventoButton);
        panelPrincipal.add(regresarButton);
    }
    
   
}
