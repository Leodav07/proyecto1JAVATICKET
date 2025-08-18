/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantallas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import login.Gestion;

/**
 *
 * @author hnleo
 */
public class VerPerfilPantalla extends JFrame {

    private Gestion gestion;

    public VerPerfilPantalla() {
        gestion = Gestion.getInstancia();
        pantalla();
    }

    public void pantalla() {
        setTitle("Perfil de Usuario");
        setSize(650, 500);
        setMinimumSize(new Dimension(550, 450));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
        panelSuperior.setBackground(new Color(33, 150, 243));
        panelSuperior.setBorder(new EmptyBorder(20, 10, 20, 10));

        JLabel titulo = new JLabel("JAVA EVENTS");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
        titulo.setForeground(Color.WHITE);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel("Mi Perfil");
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        subtitulo.setForeground(Color.WHITE);
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelSuperior.add(titulo);
        panelSuperior.add(Box.createRigidArea(new Dimension(0, 5)));
        panelSuperior.add(subtitulo);

        add(panelSuperior, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel(new BorderLayout(20, 20));
        panelCentral.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelCentral.setBackground(new Color(245, 245, 245));

        JPanel panelDatos = new JPanel(new GridLayout(5, 2, 10, 20));
        panelDatos.setBackground(new Color(245, 245, 245));

        JLabel labelUsuario = new JLabel("Usuario:");
        JLabel infoUsuario = new JLabel("infoUsuario");
        JLabel labelNombre = new JLabel("Nombre Completo:");
        JLabel infoNombre = new JLabel("infoNombre");
        JLabel labelEdad = new JLabel("Edad:");
        JLabel infoEdad = new JLabel("infoEdad");
        JLabel labelTipo = new JLabel("Rol:");
        JLabel infoTipo = new JLabel("infoRol");

        JButton regresarButton = new JButton("Regresar");
        regresarButton.setFocusPainted(false);
        regresarButton.setBackground(new Color(220, 53, 69));
        regresarButton.setForeground(Color.WHITE);
        regresarButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        regresarButton.setBorderPainted(false);
        regresarButton.setPreferredSize(new Dimension(120, 35));

        Font labelFont = new Font("Segoe UI", Font.BOLD, 14);
        Font infoFont = new Font("Segoe UI", Font.PLAIN, 14);

        labelUsuario.setFont(labelFont);
        infoUsuario.setFont(infoFont);
        labelNombre.setFont(labelFont);
        infoNombre.setFont(infoFont);
        labelEdad.setFont(labelFont);
        infoEdad.setFont(infoFont);
        labelTipo.setFont(labelFont);
        infoTipo.setFont(infoFont);

        panelDatos.add(labelUsuario);
        panelDatos.add(infoUsuario);
        panelDatos.add(labelNombre);
        panelDatos.add(infoNombre);
        panelDatos.add(labelEdad);
        panelDatos.add(infoEdad);
        panelDatos.add(labelTipo);
        panelDatos.add(infoTipo);

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(new Color(245, 245, 245));
        panelBoton.add(regresarButton);

       
        JTextArea areaEventos = new JTextArea();
        areaEventos.setEditable(false);
        areaEventos.setLineWrap(true);
        areaEventos.setWrapStyleWord(true);
        areaEventos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        areaEventos.setBackground(Color.WHITE);
        areaEventos.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(33, 150, 243), 2, true),
                new EmptyBorder(10, 10, 10, 10)
        ));

        JScrollPane scrollPane = new JScrollPane(areaEventos);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
                new LineBorder(new Color(33, 150, 243), 2, true),
                "Mis eventos",
                0,
                0,
                new Font("Segoe UI", Font.BOLD, 14),
                new Color(0, 102, 204)
        ));

        regresarButton.addActionListener(e -> {
            new GestionReportesPantalla().setVisible(true);
            this.dispose();
        });

        try {
            infoUsuario.setText(gestion.usuarioActual.getUsuario());
            infoNombre.setText(gestion.usuarioActual.getNombreCompleto());
            infoEdad.setText(String.valueOf(gestion.usuarioActual.getEdad()));
            infoTipo.setText(gestion.usuarioActual.getTipoRol());
            areaEventos.append(gestion.listaEventosUser());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        panelCentral.add(panelDatos, BorderLayout.WEST);
        panelCentral.add(scrollPane, BorderLayout.CENTER);
        panelCentral.add(panelBoton, BorderLayout.SOUTH);

        add(panelCentral, BorderLayout.CENTER);
    }

  
}
