package Main;

import Estructuras.Camino;
import Estructuras.Vertice;
import Gestores.GRASP;
import Gestores.Lector;
import Gestores.Solucion;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        double alfa=0.7;
        Solucion mejor_sol=null;
        for (int k = 0; k < 3000; k++) {
            Lector.leerArchivo();
            GRASP grasp = new GRASP();
            Solucion sol = grasp.resolver(Lector.getV(), Lector.getA(), Lector.getVerticeInicial(), alfa);
            if(sol.getTiempo_total()>=0.001){
                sol.imprimir();
                mejor_sol=Solucion.mejorSolucion(mejor_sol,sol);
            }
        }
        System.out.println();
        Lector.leerArchivo();
        Lector.imprimirV();
        System.out.println("Mejor Solucion (alfa: "+alfa+")");
        mejor_sol.imprimir();
    }

    
}
