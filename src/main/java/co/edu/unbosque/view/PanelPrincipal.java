package co.edu.unbosque.view;

import javax.swing.*;

public class PanelPrincipal extends JFrame {

    private PanelMenu panelMenu;

    public PanelPrincipal() {
        setSize(600, 561);
        setVisible(true);
        setLayout(null);
        setTitle("Menú");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panelMenu= new PanelMenu();


    }

    public PanelMenu getPanelMenu() {
        return panelMenu;
    }

    public void mostrarPanelMenu() {
        setContentPane(panelMenu);
    }


}
