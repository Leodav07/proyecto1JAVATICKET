/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class LoginVentana extends JFrame {
       private Gestion gestion;
  
        public LoginVentana(){
        gestion = Gestion.getInstancia();
        cargarComponentes();
        }
        
       private void cargarComponentes(){
        JPanel panelLogin = new JPanel();
        JLabel labelLogin = new JLabel("INICIO DE SESIÓN");
        JLabel labelUser = new JLabel("USUARIO:");
        JLabel labelPass = new JLabel("CONTRASEÑA:");
        JTextField tusuario = new JTextField();
        JPasswordField tpassword = new JPasswordField();
        JButton iniciarButton = new JButton("ENTRAR");
        JButton salirButton = new JButton("SALI");
       


        this.setSize(400, 400);
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
            try{
            String password = new String(tpassword.getPassword());
            if (gestion.loginCuenta(tusuario.getText(), password)) {
                new PantallaPrincipal().setVisible(true);
                System.out.println("Bienvenido: " + gestion.buscarUsuarios(tusuario.getText(), 0).getNombreCompleto());
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecta.", "ERROR DE INICIO", JOptionPane.ERROR_MESSAGE);
            }
            }
            catch(Exception errorInicio){
                JOptionPane.showMessageDialog(this, errorInicio.getMessage());
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

}
