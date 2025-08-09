
package pantallas;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import login.Gestion;

/**
 *
 * @author hnleo
 */
public class pantallaPrincipal extends JFrame {
    private Gestion gestion;
    
    public pantallaPrincipal(){
        try{
        if(gestion.usuarioActual.getTipoRol().equals("ADMIN")){
        pantallaAdmin();
        }else if(gestion.usuarioActual.getTipoRol().equals("CONTENIDO")){
            pantallaContenido();
        }else if(gestion.usuarioActual.getTipoRol().equals("LIMITADo")){
            pantallaLimitada();
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        gestion = Gestion.getInstancia();
    }
    
    private void pantallaAdmin(){
        JPanel panelLogin = new JPanel();
        JLabel labelLogin = new JLabel("INICIO DE SESIÓN");
        JLabel labelUser = new JLabel("USUARIO:");
        JLabel labelPass = new JLabel("CONTRASEÑA:");
        JTextField tusuario = new JTextField();
        JPasswordField tpassword = new JPasswordField();
        JButton iniciarButton = new JButton("ENTRAR");
        JButton salirButton = new JButton("SALIR");
       


        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("INICIO DE SESIÓN");
        panelLogin.setBounds(0, 0, 400, 400);
        panelLogin.setBackground(Color.WHITE);
        panelLogin.setLayout(null);

        labelLogin.setBounds(86, 10, 250, 100);
        labelLogin.setFont(new Font("Verdana", Font.BOLD, 20));
        labelLogin.setForeground(Color.BLACK);

        labelUser.setBounds(86, 70, 100, 100);
        labelUser.setFont(new Font("Verdana", Font.PLAIN, 14));
        labelUser.setForeground(Color.BLACK);

        labelPass.setBounds(86, 130, 200, 100);
        labelPass.setFont(new Font("Verdana", Font.PLAIN, 14));
        labelPass.setForeground(Color.BLACK);

        tusuario.setBounds(170, 112, 133, 20);
        tusuario.setFont(new Font("Verdana", Font.PLAIN, 14));
        tusuario.setForeground(Color.BLACK);

        tpassword.setBounds(195, 172, 111, 20);
        tpassword.setFont(new Font("Verdana", Font.PLAIN, 14));
        tpassword.setForeground(Color.BLACK);

        iniciarButton.setBounds(86, 222, 111, 30);
        iniciarButton.setFont(new Font("Verdana", Font.BOLD, 14));
        iniciarButton.setForeground(Color.BLACK);

        iniciarButton.addActionListener(e -> {
            String password = new String(tpassword.getPassword());
            if (gestion.loginCuenta(tusuario.getText(), password)) {
                System.out.println("Bienvenido: " + gestion.buscarUsuarios(tusuario.getText(), 0).getNombreCompleto());
            }else{
                System.out.println("Usuario o contraseña incorrecta.");
            }
        });

        salirButton.setBounds(206, 222, 100, 30);
        salirButton.setFont(new Font("Verdana", Font.BOLD, 14));
        salirButton.setForeground(Color.BLACK);

        salirButton.addActionListener(e -> {
            System.exit(0);
        });

        this.add(panelLogin);
        panelLogin.add(labelLogin);
        panelLogin.add(labelUser);
        panelLogin.add(labelPass);
        panelLogin.add(tusuario);
        panelLogin.add(tpassword);
        panelLogin.add(iniciarButton);
        panelLogin.add(salirButton);

    }
    
    private void pantallaContenido(){
        
    }
    
    private void pantallaLimitada(){
        
    }
    
    private void verificarUser(){
        
    }
}
