/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantallas;

import javax.swing.*;
import java.awt.*;
import login.Gestion;

/**
 *
 * @author hnleo
 */
public class EventosFuturosPantalla extends JFrame {

    private JTextArea textAreaEventos;
    private JButton btnRegresar;
    private Gestion gestion;

    public EventosFuturosPantalla() {
    gestion = Gestion.getInstancia();
    pantalla();
    }
    public void pantalla(){    
        setTitle("JAVA EVENTS - Listado de Eventos ");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(Color.WHITE);
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelTitulos = new JPanel();
        panelTitulos.setLayout(new BoxLayout(panelTitulos, BoxLayout.Y_AXIS));
        panelTitulos.setBackground(Color.WHITE);

        JLabel titulo = new JLabel("JAVA EVENTS", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel("Listado de eventos futuros", SwingConstants.CENTER);
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 18));
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelTitulos.add(titulo);
        panelTitulos.add(Box.createVerticalStrut(5));
        panelTitulos.add(subtitulo);

        btnRegresar = new JButton("Regresar");
        btnRegresar.setPreferredSize(new Dimension(100, 35));
        btnRegresar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnRegresar.setForeground(Color.WHITE);
        btnRegresar.setBackground(new Color(220, 53, 69));
        btnRegresar.setFocusPainted(false);
        btnRegresar.setBorder(BorderFactory.createEmptyBorder());
        btnRegresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRegresar.setOpaque(true);

        panelSuperior.add(panelTitulos, BorderLayout.CENTER);
        panelSuperior.add(btnRegresar, BorderLayout.EAST);

        textAreaEventos = new JTextArea();
        textAreaEventos.setEditable(false);
        textAreaEventos.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textAreaEventos.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(textAreaEventos);

        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        try{
        
        textAreaEventos.append(gestion.listadoEventosRealizados("Activo"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: No hay eventos que mostrar." + e.getMessage());
            
        }
        
        btnRegresar.addActionListener(e -> {
            new GestionReportesPantalla().setVisible(true);
            this.dispose();
        });
    }


}

