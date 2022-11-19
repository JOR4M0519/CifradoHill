package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelMenu extends JPanel {

    private JTextArea titulo;
    private JButton encriptar, desencriptar;


    public PanelMenu() {

        Font fuente=new Font("Century Gothic", Font.BOLD, 23);
        setLayout(null);
        setSize(586, 533);
        setVisible(true);
        setBackground(new Color(180, 232, 250));

        encriptar = new JButton("Encriptar mensaje");
        encriptar.setFont(fuente);
        encriptar.setActionCommand("ENCRIPTAR");
        encriptar.setBackground(new Color(217, 237, 244));
        encriptar.setBorderPainted(true);
        encriptar.setFocusPainted(false);
        encriptar.setBounds(166,110, 280, 45);
        add(encriptar);

        desencriptar = new JButton("Desencriptar mensaje");
        desencriptar.setFont(fuente);
        desencriptar.setActionCommand("DESENCRIPTAR");
        desencriptar.setBackground(new Color(217, 237, 244));
        desencriptar.setBorderPainted(true);
        desencriptar.setFocusPainted(false);
        desencriptar.setBounds(166,180, 280, 45);
        add(desencriptar);

        titulo= new JTextArea("Menú principal cifrado de Hill");
        titulo.setFont(new Font("Century Gothic", Font.BOLD, 45));
        titulo.setBounds(140,0,345,100);
        add(titulo);

    }

}
