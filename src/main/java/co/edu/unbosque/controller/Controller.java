package co.edu.unbosque.controller;

import Jama.Matrix;
import co.edu.unbosque.view.PanelPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller implements ActionListener {

    private ArrayList<String> tabla;
    private double[][] clave;
    private double[][] mensaje;
    private PanelPrincipal panel;

    private boolean encriptar;

    public Controller() {
        panel = new PanelPrincipal();
        panel.mostrarPanelMenu();
        tabla = new ArrayList<>();
        cargarTabla();

        //ActionListener
        panel.getPanelMenu().getDesencriptar().addActionListener(this);
        panel.getPanelMenu().getEncriptar().addActionListener(this);
        panel.getPanelResultado().getRegresar().addActionListener(this);
        panel.getPanelResultado().getMostrar().addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("ENCRIPTAR")) {
            encriptar = true;
            panel.mostrarPanelResultado();
        }

        if (e.getActionCommand().equals("DESENCRIPTAR")) {
            encriptar = false;
            panel.mostrarPanelResultado();
        }

        if (e.getActionCommand().equals("MOSTRAR")) {
            panel.getPanelResultado().setResultado("");
            try {
                if (!panel.getPanelResultado().getClaveIngresadaTxt().replaceAll(" ", "").equals("")
                        && !panel.getPanelResultado().getMensajeTxt().replaceAll(" ", "").equals("")
                        && !panel.getPanelResultado().getFilasIngresadasTxt().replaceAll(" ", "").equals("")) {
                    if (coincidirLetra(panel.getPanelResultado().getClaveIngresadaTxt())
                            && coincidirLetra(panel.getPanelResultado().getMensajeTxt())
                            && !panel.getPanelResultado().getMensajeTxt().contains("ñ")
                            && !panel.getPanelResultado().getClaveIngresadaTxt().contains("ñ")) {
                        int fila = Integer.valueOf(panel.getPanelResultado().getFilasIngresadasTxt());
                        if (fila < 1 || fila > panel.getPanelResultado().getMensajeTxt().length()) {
                            System.out.println("el numero no puede ser menor y no puede ser mayor al mensaje");
                        } else {
                            if (panel.getPanelResultado().getClaveIngresadaTxt().length()<=(fila*fila)) {
                                if (cargarMatrices(panel.getPanelResultado().getMensajeTxt()
                                        , panel.getPanelResultado().getClaveIngresadaTxt(),
                                        Integer.parseInt(panel.getPanelResultado().getFilasIngresadasTxt()))) {
                                    if (encriptar) {
                                        panel.getPanelResultado().setResultado(encriptar());
                                    } else {
                                        panel.getPanelResultado().setResultado(desencriptar());
                                    }
                                } else {
                                    System.out.println("La clave no es valida");
                                }
                            }else{
                                System.out.println("La clave debe ser menor a "+(fila*fila)+" caracteres");
                            }
                        }
                    } else {
                        System.out.println("no puden haber numeros, ni ene, ");
                    }
                } else {
                    System.out.println("Campo no ingresado");
                }
            } catch (NumberFormatException y) {
                System.out.println("Ingreso de letras en vez de numeros");
            }
        }

        if (e.getActionCommand().equals("REGRESAR")) {
            panel.mostrarPanelMenu();
            panel.getPanelResultado().setResultado("");
            panel.getPanelResultado().setClaveIngresadaTxt("");
            panel.getPanelResultado().setMensajeTxt("");
            panel.getPanelResultado().setFilasIngresadasTxt("");
        }


    }

    public static void main(String[] args) {
        new Controller();
    }


    public String desencriptar() {

        //Invertida
        double det = (new Matrix(this.clave)).det();
        long modInv = (new BigInteger(String.valueOf((int) det)).modInverse(new BigInteger("27")).longValue());


        double[][] descifrado = (new Matrix(this.clave)).inverse().times(det).times(modInv).getArray();
        descifrado = (new Matrix(descifrado)).times((new Matrix(this.mensaje))).getArray();

        return encriptarDesencriptar(descifrado);
    }

    public String encriptar() {
        //Multiplicar

        double[][] cifrado = (new Matrix(this.clave)).times(new Matrix(this.mensaje)).getArray();

        return encriptarDesencriptar(cifrado);
    }

    public void cargarTabla() {
        for (int i = 97; i <= 122; i++) tabla.add(Character.toString(i));
        tabla.add("_");
    }

    public boolean cargarMatrices(String mensaje, String clave, int filas) {

        int columnas = mensaje.length() / filas;
        if (mensaje.length() % filas != 0) columnas++;
        this.clave = new double[filas][filas];

        this.mensaje = new double[filas][columnas];

        mensaje = mensaje.toLowerCase();
        clave = clave.toLowerCase();
        this.mensaje = rellenarMatriz(this.mensaje, mensaje);
        this.clave = rellenarMatriz(this.clave, clave);

        Arrays.stream(this.clave).map(Arrays::toString).forEach(System.out::println);


        Matrix temp = new Matrix(this.clave);
        int determinante = (int) temp.det();
        System.out.println(determinante);
        if (determinante == 0 || tieneFactores(determinante)) return false;

        return true;
    }

    public boolean tieneFactores(int determinante) {
        int temporal;
        int b = determinante;
        int a = this.tabla.size();
        while (b != 0) {
            temporal = b;
            b = a % b;
            a = temporal;
        }
        System.out.println(a);
        if (a != 1) {
            return true;
        }
        return false;
    }


    public double[][] rellenarMatriz(double[][] matriz, String palabra) {
        int count = 0;
        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (count <= (palabra.length() - 1))
                    matriz[j][i] = tabla.indexOf(String.valueOf(palabra.charAt(count)));
                else matriz[j][i] = 26;
                count++;
            }
        }
        return matriz;
    }

    public String encriptarDesencriptar(double[][] matriz) {
        String resultado = "";
        //Modulo
        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                //double x = matriz[j][i];
                double x =(int) (Math.round(matriz[j][i]));
                int y = 27;
                matriz[j][i] = (x < 0) ? (y - (Math.abs(x) % y)) % y : (x % y);
                //Convierte al alfabeto
                resultado += tabla.get((int) matriz[j][i]);
            }
        }
        return resultado;
    }

    public boolean coincidirLetra(String palabra) {
        palabra = palabra.toLowerCase();
        for (Character c : palabra.toCharArray())
            if (tabla.indexOf(Character.toString(c)) == -1) return false;

        return true;
    }
}
