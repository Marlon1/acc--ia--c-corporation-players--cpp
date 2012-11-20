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
        //Lector.Imprimir
        System.out.println("Mejor Solucion (alfa: "+alfa+")");
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
