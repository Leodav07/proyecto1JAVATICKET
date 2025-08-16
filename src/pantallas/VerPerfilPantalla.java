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
        setSize(600, 500);
        setMinimumSize(new Dimension(500, 500));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
        panelSuperior.setBackground(new Color(135, 206, 250));
        panelSuperior.setBorder(new EmptyBorder(15, 10, 15, 10));

        JLabel titulo = new JLabel("JAVA EVENTS");
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(Color.WHITE);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel("Mi Perfil");
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 18));
        subtitulo.setForeground(Color.WHITE);
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelSuperior.add(titulo);
        panelSuperior.add(Box.createRigidArea(new Dimension(0, 5)));
        panelSuperior.add(subtitulo);

        add(panelSuperior, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel(new BorderLayout(20, 20));
        panelCentral.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelCentral.setBackground(new Color(245, 245, 245));

        JPanel panelIzquierdo = new JPanel(new GridLayout(6, 2, 10, 20));
        panelIzquierdo.setBackground(new Color(245, 245, 245));

        JLabel labelUsuario = new JLabel("Usuario:");
        JLabel infoUsuario = new JLabel("infoUsuario");
        JLabel labelNombre = new JLabel("Nombre Completo:");
        JLabel infoNombre = new JLabel("infoNombre");
        JLabel labelEdad = new JLabel("Edad:");
        JLabel infoEdad = new JLabel("infoEdad");
        JLabel labelTipo = new JLabel("Rol:");
        JLabel infoTipo = new JLabel("infoRol");
        JButton regresarButton = new JButton("Regresar");

        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font infoFont = new Font("Arial", Font.PLAIN, 14);

        labelUsuario.setFont(labelFont);
        infoUsuario.setFont(infoFont);
        labelNombre.setFont(labelFont);
        infoNombre.setFont(infoFont);
        labelEdad.setFont(labelFont);
        infoEdad.setFont(infoFont);
        labelTipo.setFont(labelFont);
        infoTipo.setFont(infoFont);
        regresarButton.setFont(labelFont);

        panelIzquierdo.add(labelUsuario);
        panelIzquierdo.add(infoUsuario);
        panelIzquierdo.add(labelNombre);
        panelIzquierdo.add(infoNombre);
        panelIzquierdo.add(labelEdad);
        panelIzquierdo.add(infoEdad);
        panelIzquierdo.add(labelTipo);
        panelIzquierdo.add(infoTipo);
        panelIzquierdo.add(regresarButton);

        regresarButton.addActionListener(e -> {
            new GestionReportesPantalla().setVisible(true);
            this.dispose();
        });

        JTextArea areaDerecha = new JTextArea();
        areaDerecha.setEditable(false);
        areaDerecha.setLineWrap(true);
        areaDerecha.setWrapStyleWord(true);
        areaDerecha.setFont(new Font("Arial", Font.PLAIN, 14));
        areaDerecha.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(135, 206, 250), 2, true),
                new EmptyBorder(10, 10, 10, 10)
        ));
        areaDerecha.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(areaDerecha);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
                new LineBorder(new Color(135, 206, 250), 2, true),
                "Mi lista de eventos",
                0,
                0,
                new Font("Arial", Font.BOLD, 14),
                new Color(0, 102, 204)
        ));

        try {
            infoUsuario.setText(gestion.usuarioActual.getUsuario());
            infoNombre.setText(gestion.usuarioActual.getNombreCompleto());
            infoEdad.setText(String.valueOf(gestion.usuarioActual.getEdad()));
            infoTipo.setText(gestion.usuarioActual.getTipoRol());
            areaDerecha.append(gestion.listaEventosUser());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        panelCentral.add(panelIzquierdo, BorderLayout.WEST);
        panelCentral.add(scrollPane, BorderLayout.CENTER);

        add(panelCentral, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new VerPerfilPantalla().setVisible(true);
    }

}
