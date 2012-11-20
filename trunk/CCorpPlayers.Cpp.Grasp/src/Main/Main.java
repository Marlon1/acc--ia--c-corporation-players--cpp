package Main;

import Estructuras.Arista;
import Estructuras.Camino;
import Estructuras.Vertice;
import Gestores.GRASP;
import Gestores.Lector;
import Gestores.Solucion;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Solucion mejor_sol=null;
        for (int k = 0; k < 10000; k++) {
            Lector.leerArchivo();
            GRASP grasp = new GRASP();
            Solucion sol = grasp.resolver(Lector.getV(), Lector.getA(), Lector.getVerticeInicial(), 0);
            sol.imprimir();
            mejor_sol=Solucion.mejorSolucion(mejor_sol,sol);
        }
        mejor_sol.imprimir();
    }

    static public void imprimir(ArrayList<Vertice> lista) {
        Vertice v;
        Camino c;
        for (int i = 0; i < lista.size(); i++) {
            v = lista.get(i);
            System.out.println(v.getNombre());
            for (int j = 0; j < v.getListaCaminos().size(); j++) {
                c = v.getListaCaminos().get(j);
                System.out.println("    " + c.getArista().getNombre() + " " + c.getDestino().getNombre());
            }
        }
    }
}
