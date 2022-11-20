package co.edu.unbosque.view;

import javax.swing.*;

public class PanelPrincipal extends JFrame {

    private PanelMenu panelMenu;
    private PanelResultado panelResultado;

    public PanelPrincipal() {
        setSize(600, 561);
        setVisible(true);
        setLayout(null);
        setTitle("Menú");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panelMenu= new PanelMenu();
        panelResultado= new PanelResultado();

    }

    public PanelMenu getPanelMenu() {
        return panelMenu;
    }

    public PanelResultado getPanelResultado() { return panelResultado; }

    public void mostrarPanelMenu() {
        setContentPane(panelMenu);
    }

    public void mostrarPanelResultado() {
        setContentPane(panelResultado);
    }

}
