package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelMenu extends JPanel {

    private JLabel titulo;
    private JButton encriptar, desencriptar;


    public PanelMenu() {

        Font fuente=new Font("Century Gothic", Font.BOLD, 26);
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
        encriptar.setBounds(125,160, 360, 55);
        add(encriptar);

        desencriptar = new JButton("Desencriptar mensaje");
        desencriptar.setFont(fuente);
        desencriptar.setActionCommand("DESENCRIPTAR");
        desencriptar.setBackground(new Color(217, 237, 244));
        desencriptar.setBorderPainted(true);
        desencriptar.setFocusPainted(false);
        desencriptar.setBounds(125,260, 360, 55);
        add(desencriptar);

        titulo= new JLabel ("Cifrado de Hill");
        titulo.setFont(new Font("Century Gothic", Font.BOLD, 50));
        titulo.setBounds(143,25,360,70);
        add(titulo);

    }

    public JButton getEncriptar() {
        return encriptar;
    }

    public JButton getDesencriptar() {
        return desencriptar;
    }

}
