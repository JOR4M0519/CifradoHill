package co.edu.unbosque.view;
import javax.swing.*;
import java.awt.*;

public class PanelResultado extends JPanel {

    private JLabel titulo, mensaje, clave;
    private JTextArea resultado, filas,mensajeTxt, claveIngresadaTxt, filasIngresadasTxt;
    private JButton mostrar,regresar;

    public PanelResultado() {

        Font fuente=new Font("Century Gothic", Font.BOLD, 20);
        Font fuenteDos=new Font("Century Gothic", Font.BOLD, 18);

        setLayout(null);
        setSize(586, 533);
        setVisible(true);
        setBackground(new Color(180, 232, 250));

        mensaje = new JLabel("Mensaje:");
        mensaje.setFont(fuente);
        mensaje.setBackground(Color.red);
        mensaje.setBounds(30,20, 120, 30);
        add(mensaje);

        mensajeTxt = new JTextArea();
        mensajeTxt.setFont(fuenteDos);
        JScrollPane scrollPaneUno = new JScrollPane(mensajeTxt);
        scrollPaneUno.setBounds(160,13, 370, 55);
        add(scrollPaneUno);

        clave= new JLabel("Clave:");
        clave.setFont(fuente);
        clave.setBounds(30,85, 120, 30);
        add(clave);

        claveIngresadaTxt= new JTextArea();
        claveIngresadaTxt.setFont(fuenteDos);
        JScrollPane scrollPaneDos = new JScrollPane(claveIngresadaTxt);
        scrollPaneDos.setBounds(160,80, 270, 50);
        add(scrollPaneDos);

        filas = new JTextArea("Bloques a dividir\nla palabra:");
        filas.setFont(fuente);
        filas.setOpaque(false);
        filas.setEditable(false);
        filas.setBounds(30,153, 260, 60);
        add(filas);

        filasIngresadasTxt= new JTextArea();
        filasIngresadasTxt.setFont(fuenteDos);
        JScrollPane scrollPaneTres = new JScrollPane(filasIngresadasTxt);
        scrollPaneTres.setBounds(210,154, 222, 50);
        add(scrollPaneTres);

        resultado= new JTextArea();
        resultado.setEditable(false);
        resultado.setFont(fuente);
        JScrollPane scrollPane = new JScrollPane(resultado);
        scrollPane.setBounds(30,265, 530, 200);
        add(scrollPane);

        mostrar= new JButton("Mostrar");
        mostrar.setFont(fuente);
        mostrar.setActionCommand("MOSTRAR");
        mostrar.setBackground(new Color(217, 237, 244));
        mostrar.setBorderPainted(true);
        mostrar.setFocusPainted(false);
        mostrar.setBounds(230,225, 140, 28);
        add(mostrar);

        regresar= new JButton("Regresar");
        regresar.setFont(new Font("Century Gothic", Font.BOLD, 16));
        regresar.setActionCommand("REGRESAR");
        regresar.setBackground(new Color(217, 237, 244));
        regresar.setBorderPainted(true);
        regresar.setFocusPainted(false);
        regresar.setBounds(230,478, 140, 28);
        add(regresar);

    }

    public void setResultado(String resultado) {
        this.resultado.setText(resultado);
    }

    public JButton getRegresar() {
        return regresar;
    }

    public JButton getMostrar() {
        return mostrar;
    }

    public String getResultado() {
        return resultado.getText();
    }

    public String getMensajeTxt() {
        return mensajeTxt.getText();
    }

    public String getClaveIngresadaTxt() {
        return claveIngresadaTxt.getText();
    }

    public String getFilasIngresadasTxt() {
        return filasIngresadasTxt.getText();
    }

    public void setMensajeTxt(String mensajeTxt) {
        this.mensajeTxt.setText(mensajeTxt);
    }

    public void setClaveIngresadaTxt(String claveIngresadaTxt) {
        this.claveIngresadaTxt.setText(claveIngresadaTxt);
    }

    public void setFilasIngresadasTxt(String filasIngresadasTxt) {
        this.filasIngresadasTxt.setText(filasIngresadasTxt);
    }
}
