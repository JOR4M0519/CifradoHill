package co.edu.unbosque.controller;

import Jama.Matrix;
import co.edu.unbosque.view.PanelPrincipal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Controller {

    private ArrayList<String> tabla;
    private double[][] clave;
    private double[][] cifrado;
    private double[][] mensaje;
    public Controller() {
        tabla = new ArrayList<>();
        cargarTabla();

        String encriptado = encriptar("CODIGO","FJCRXLUDN",3);
        System.out.println(encriptado);
        System.out.println("Desencriptar: ");
        System.out.println(desencriptar(encriptado,"FJCRXLUDN",3));

    }

    public static void main(String[] args) {
        new Controller();
        PanelPrincipal panel= new PanelPrincipal();
        panel.mostrarPanelMenu();

    }

    public String desencriptar(String cifrado,String clave, int filas) {
        cargarMatrices(cifrado, clave, filas);

        //Invertida
        double[][] descifrado = (new Matrix(this.clave)).times(new Matrix(this.cifrado)).getArray();
        System.out.println("\n Antes: ");
        Arrays.stream(descifrado).map(Arrays::toString).forEach(System.out::println);
        System.out.println("\n\n\n Descifrado: ");
        return encriptarDesencriptar(descifrado);
    }

    public String encriptar(String mensaje,String clave, int filas){
        cargarMatrices(mensaje,clave,filas);

        System.out.println("Mensaje:");
        Arrays.stream(this.mensaje).map(Arrays::toString).forEach(System.out::println);
        System.out.println("\n Clave");
        Arrays.stream(this.clave).map(Arrays::toString).forEach(System.out::println);

        System.out.println("Determinante: (Clave) "+ (new Matrix(this.clave)).det());

        //Multiplicar
        double[][] cifrado1=(new Matrix(this.clave)).getArray();

        System.out.println("\n Inversa");
        Arrays.stream(cifrado1).map(Arrays::toString).forEach(System.out::println);

        double[][] cifrado=(new Matrix(cifrado1)).inverse().times(new Matrix(this.mensaje)).getArray();
        System.out.println("\n Multiplicar");
        Arrays.stream(cifrado).map(Arrays::toString).forEach(System.out::println);

        System.out.println("\n Cifrado: ");
        return encriptarDesencriptar(cifrado);
    }

    public void cargarTabla(){
        for(int i=97;i<=122;i++) tabla.add(Character.toString(i));
        tabla.add(" ");
    }

    public void cargarMatrices(String mensaje, String clave, int filas){

        int columnas = mensaje.length()/filas;

        if(mensaje.length() % filas !=0)    columnas++;

        this.clave = new double[filas][filas];
        this.mensaje = new double[filas][columnas];

        mensaje = mensaje.toLowerCase(Locale.ROOT);
        clave = clave.toLowerCase(Locale.ROOT);
        this.mensaje = rellenarMatriz(this.mensaje,mensaje);
        this.clave = rellenarMatriz(this.clave,clave);

    }


    public double[][] rellenarMatriz(double[][] matriz, String palabra){
        int count=0;
        for (int i =0; i<matriz[0].length;i++){
            for (int j =0; j<matriz.length;j++){
                if(count <=(palabra.length()-1))
                    matriz[j][i] = tabla.indexOf(String.valueOf(palabra.charAt(count)));
                else matriz[j][i] = 26;
                count++;
            }
        }
        return matriz;
    }

    public String encriptarDesencriptar(double[][] matriz){
        String resultado = "";
        //Modulo
        for (int i =0; i<matriz[0].length;i++){
            for (int j =0; j<matriz.length;j++){
                double x = matriz[j][i];
                int y = 26;
                matriz[j][i] = (x < 0) ? (y - (Math.abs(x) % y) ) %y : (x % y);
                //Convierte al alfabeto
                resultado += tabla.get((int) matriz[j][i]);
            }
        }
        cifrado = matriz;
        Arrays.stream(matriz).map(Arrays::toString).forEach(System.out::println);
        return resultado;
    }


}
