package co.edu.unbosque.controller;

import Jama.Matrix;
import co.edu.unbosque.view.PanelPrincipal;

public class Controller {



    public Controller() {
        
    }

    public static void main(String[] args) {
        PanelPrincipal panel= new PanelPrincipal();
        panel.mostrarPanelResultado();
        double[][] a = {{4., 2.}, {1., 3.}};
        double[][] b = {{2., 8.}, {3., 1.}};
        Matrix matris = new Matrix(a);
        Matrix matris2 = new Matrix(b);
        System.out.println(matris.det() + "-----");
//        double[][] ete=matris.getArray();
//        for(int x=0;x<2;x++){
//            for(int y=0;y<2;y++){
//                System.out.println(ete[x][y]);
//            }
//        }



        double[][] ete2 = matris.inverse().getArray();
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                System.out.println(ete2[x][y]);
            }
        }

//        double[][] ete2=matris.times(matris2).getArray();
//        for(int x=0;x<2;x++){
//            for(int y=0;y<2;y++){
//                System.out.println(ete2[x][y]);
//            }
//        }
    }


}