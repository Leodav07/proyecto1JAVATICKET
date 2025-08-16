package pantallas;

import javax.swing.*;
import java.awt.*;
import login.Gestion;
import com.toedter.calendar.JDateChooser; // Importante para los JDateChooser

public class EventosPorRangoPantalla extends JFrame {

    private JTextArea textAreaEventos;
    private JButton btnRegresar, btnBuscar;
    private Gestion gestion;
    private JDateChooser fechaInicialChooser, fechaFinalChooser;

    public EventosPorRangoPantalla() {
        gestion = Gestion.getInstancia();
        pantalla();
    }

    public void pantalla() {
        setTitle("JAVA EVENTS - Listado de Eventos ");
        setSize(690, 650);
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

        JLabel subtitulo = new JLabel("Listado de eventos por rango de fechas", SwingConstants.CENTER);
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 18));
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelTitulos.add(titulo);
        panelTitulos.add(Box.createVerticalStrut(5));
        panelTitulos.add(subtitulo);

        btnRegresar = new JButton("Regresar");
        btnRegresar.setPreferredSize(new Dimension(100, 35));

        panelSuperior.add(panelTitulos, BorderLayout.CENTER);
        panelSuperior.add(btnRegresar, BorderLayout.EAST);

        JPanel panelFechas = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); // espacio horizontal de 20px
        panelFechas.setBackground(Color.WHITE);

        JLabel lblFechaInicial = new JLabel("Fecha Inicial:");
        fechaInicialChooser = new JDateChooser();
        fechaInicialChooser.setPreferredSize(new Dimension(150, 30));

        JLabel lblFechaFinal = new JLabel("Fecha Final:");
        fechaFinalChooser = new JDateChooser();
        fechaFinalChooser.setPreferredSize(new Dimension(150, 30));

        btnBuscar = new JButton("Buscar");
        btnBuscar.setPreferredSize(new Dimension(80, 30));

        panelFechas.add(lblFechaInicial);
        panelFechas.add(fechaInicialChooser);
        panelFechas.add(lblFechaFinal);
        panelFechas.add(fechaFinalChooser);
        panelFechas.add(btnBuscar);

        textAreaEventos = new JTextArea();
        textAreaEventos.setEditable(false);
        textAreaEventos.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textAreaEventos.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(textAreaEventos);
      
        JPanel panelTop = new JPanel();
        panelTop.setLayout(new BorderLayout());
        panelTop.add(panelSuperior, BorderLayout.NORTH);
        panelTop.add(panelFechas, BorderLayout.SOUTH);

        add(panelTop, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        btnBuscar.addActionListener(e->{
            try{
            textAreaEventos.append("");
            textAreaEventos.append(gestion.eventoPorRango(fechaInicialChooser.getCalendar(), fechaFinalChooser.getCalendar()));
            }catch(Exception s){
                JOptionPane.showMessageDialog(this, "Error: "+s.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnRegresar.addActionListener(e -> {
            new GestionReportesPantalla().setVisible(true);
            this.dispose();
        });
    }

    
}
