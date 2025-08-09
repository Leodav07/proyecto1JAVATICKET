package pantallas;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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

    private void pantallaAdmin() {
        JPanel panelPrincipal = new JPanel();
        JLabel labelTitulo = new JLabel("JAVA EVENTS", SwingConstants.CENTER);
        JLabel labelSubtitulo = new JLabel("Maneja perfectamente tus eventos.", SwingConstants.CENTER);

        JButton adminEventButton = new JButton("Administrar Eventos");
        JButton adminUserButton = new JButton("Administrar Usuarios");
        JButton reportesButton = new JButton("Listado de Reportes");
        JButton cerrarSesionButton = new JButton("Cerrar Sesión");

        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("JAVA EVENTS");
        panelPrincipal.setBounds(0, 0, 800, 600);
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setLayout(null);

        labelTitulo.setBounds(0, 50, 800, 40);
        labelTitulo.setFont(new Font("Verdana", Font.BOLD, 28));
        labelTitulo.setForeground(Color.BLACK);

        labelSubtitulo.setBounds(0, 90, 800, 25);
        labelSubtitulo.setFont(new Font("Verdana", Font.BOLD, 16));
        labelSubtitulo.setForeground(Color.BLACK);

        adminEventButton.setBounds(300, 160, 200, 35);
        adminEventButton.setFont(new Font("Verdana", Font.BOLD, 14));
        adminEventButton.setForeground(Color.BLACK);

        adminUserButton.setBounds(290, 210, 220, 35);
        adminUserButton.setFont(new Font("Verdana", Font.BOLD, 14));
        adminUserButton.setForeground(Color.BLACK);

        reportesButton.setBounds(300, 260, 200, 35);
        reportesButton.setFont(new Font("Verdana", Font.BOLD, 14));
        reportesButton.setForeground(Color.BLACK);

        cerrarSesionButton.setBounds(300, 310, 200, 35);
        cerrarSesionButton.setFont(new Font("Verdana", Font.BOLD, 14));
        cerrarSesionButton.setForeground(Color.BLACK);

        cerrarSesionButton.addActionListener(e -> {
          cerrarSesionUser();
        });

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
        JLabel labelTitulo = new JLabel("JAVA EVENTS", SwingConstants.CENTER);
        JLabel labelSubtitulo = new JLabel("Maneja perfectamente tus eventos.", SwingConstants.CENTER);

        JButton adminEventButton = new JButton("Administrar Eventos");
        JButton reportesButton = new JButton("Listado de Reportes");
        JButton cerrarSesionButton = new JButton("Cerrar Sesión");

        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("JAVA EVENTS");
        panelPrincipal.setBounds(0, 0, 800, 600);
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setLayout(null);

        labelTitulo.setBounds(0, 50, 800, 40);
        labelTitulo.setFont(new Font("Verdana", Font.BOLD, 28));
        labelTitulo.setForeground(Color.BLACK);

        labelSubtitulo.setBounds(0, 90, 800, 25);
        labelSubtitulo.setFont(new Font("Verdana", Font.BOLD, 16));
        labelSubtitulo.setForeground(Color.BLACK);

        adminEventButton.setBounds(300, 160, 200, 35);
        adminEventButton.setFont(new Font("Verdana", Font.BOLD, 14));
        adminEventButton.setForeground(Color.BLACK);

        reportesButton.setBounds(290, 210, 220, 35);
        reportesButton.setFont(new Font("Verdana", Font.BOLD, 14));
        reportesButton.setForeground(Color.BLACK);

        cerrarSesionButton.setBounds(300, 260, 200, 35);
        cerrarSesionButton.setFont(new Font("Verdana", Font.BOLD, 14));
        cerrarSesionButton.setForeground(Color.BLACK);

        cerrarSesionButton.addActionListener(e -> {
        cerrarSesionUser();
        });

        this.add(panelPrincipal);
        panelPrincipal.add(labelTitulo);
        panelPrincipal.add(labelSubtitulo);
        panelPrincipal.add(adminEventButton);
        panelPrincipal.add(reportesButton);
        panelPrincipal.add(cerrarSesionButton);
    }

    private void pantallaLimitada() {
        JPanel panelPrincipal = new JPanel();
        JLabel labelTitulo = new JLabel("JAVA EVENTS", SwingConstants.CENTER);
        JLabel labelSubtitulo = new JLabel("Maneja perfectamente tus eventos.", SwingConstants.CENTER);

        JButton verEventosButton = new JButton("Ver Eventos");
        JButton reportesButton = new JButton("Listado de Reportes");
        JButton cerrarSesionButton = new JButton("Cerrar Sesión");

        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("JAVA EVENTS");
        panelPrincipal.setBounds(0, 0, 800, 600);
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setLayout(null);

        labelTitulo.setBounds(0, 50, 800, 40);
        labelTitulo.setFont(new Font("Verdana", Font.BOLD, 28));
        labelTitulo.setForeground(Color.BLACK);

        labelSubtitulo.setBounds(0, 90, 800, 25);
        labelSubtitulo.setFont(new Font("Verdana", Font.BOLD, 16));
        labelSubtitulo.setForeground(Color.BLACK);

        verEventosButton.setBounds(300, 160, 200, 35);
        verEventosButton.setFont(new Font("Verdana", Font.BOLD, 14));
        verEventosButton.setForeground(Color.BLACK);

        reportesButton.setBounds(290, 210, 220, 35);
        reportesButton.setFont(new Font("Verdana", Font.BOLD, 14));
        reportesButton.setForeground(Color.BLACK);

        cerrarSesionButton.setBounds(300, 260, 200, 35);
        cerrarSesionButton.setFont(new Font("Verdana", Font.BOLD, 14));
        cerrarSesionButton.setForeground(Color.BLACK);

        cerrarSesionButton.addActionListener(e -> {
        cerrarSesionUser();
        });

        this.add(panelPrincipal);
        panelPrincipal.add(labelTitulo);
        panelPrincipal.add(labelSubtitulo);
        panelPrincipal.add(reportesButton);
        panelPrincipal.add(cerrarSesionButton);
    }

    private void verificarUser() {
        try {
            if (gestion.usuarioActual.getTipoRol().equals("ADMIN")) {
                pantallaAdmin();
                System.out.println("USER ACTUAL:"+gestion.usuarioActual.getUsuario()+" ADMIN");
            } else if (gestion.usuarioActual.getTipoRol().equals("CONTENIDO")) {
                pantallaContenido();
                System.out.println("USER ACTUAL: "+gestion.usuarioActual.getUsuario()+" CONTENIDO");
            } else if (gestion.usuarioActual.getTipoRol().equals("LIMITADO")) {
                pantallaLimitada();
                System.out.println("USER ACTUAL:"+gestion.usuarioActual.getUsuario()+" LIMITADO");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void cerrarSesionUser(){
          try{
           if(gestion.usuarioActual!=null){
          gestion.usuarioActual = null;
          new loginVentana().setVisible(true);
          this.dispose();
           }
            } 
            catch(Exception i){
                System.out.println(i.getMessage());
            }
    }
}
