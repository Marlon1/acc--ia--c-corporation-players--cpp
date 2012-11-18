/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Estructuras.Arista;
import Estructuras.Camino;
import Estructuras.Vertice;
import java.util.ArrayList;

/**
 *
 * @author Guti
 */
public class GRASP {
    private ArrayList<Arista> A;
    private ArrayList<Vertice> V;
    private Solucion S;
    private Vertice inicio;
    float tiempo_total;
            
    public Solucion GRASP(float alfa){
        float beta,tau;
        S=new Solucion();
        Camino camino;
        Arista arista;
        Vertice posicion=inicio;
        tiempo_total=0;
        S.add(inicio);
        while(!((posicion==inicio)&&A.isEmpty())){
            beta=max(V,posicion);
            tau=min(V,posicion);
            camino=hallarAleatorio(V,posicion,alfa,beta,tau);
            posicion=camino.getDestino();
            S.add(posicion);
            arista=camino.getArista();
            if(!arista.isRecorrido()){
                A.remove(camino.getArista());
                camino.getArista().setRecorrido(true);
            }
            tiempo_total+=camino.getTiempo();
        }
        return S;
    }

    private void inicializar() {
        //leer de archivo los datos y cargarlos a A, V e inicio.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private int max(ArrayList<Vertice> A, Vertice posicion) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private int min(ArrayList<Vertice> A, Vertice posicion) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private Camino hallarAleatorio(ArrayList<Vertice> A, Vertice posicion, float alfa, float beta1, float tau1) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
