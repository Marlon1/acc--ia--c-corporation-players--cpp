package Gestores;

import Estructuras.Arista;
import Estructuras.Camino;
import Estructuras.Vertice;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Guti
 */
public class GRASP {
    private ArrayList<Arista> A;
    private ArrayList<Vertice> V;
    private Solucion S;
    private Vertice inicio;
            

    public Solucion resolver(ArrayList<Vertice> V_, ArrayList<Arista> A_,  Vertice inicio_,float alfa){
        Camino beta,tau;        
        Camino camino;
        Arista arista;
        
        //no se si esto va:
        inicializar(A_,V_,inicio_); //copiar
        
        Vertice posicion=inicio;
        S=new Solucion();
        S.setTiempo_total(0);
        S.agregar(inicio);
        while(!((posicion==inicio)&&A.isEmpty())){
            beta=max(posicion);
            tau=min(posicion);
            
            camino=hallarAleatorio(posicion,alfa,beta,tau);
            posicion=camino.getDestino();
            
            S.agregar(posicion);
            S.incrementarTiempo(camino.getTiempo());
            arista=camino.getArista();
            if(!arista.isRecorrido()){
                A.remove(camino.getArista());
                camino.getArista().setRecorrido(true);
            }
        }
        return S;
    }

    private void inicializar(ArrayList<Arista> A_, ArrayList<Vertice> V_, Vertice inicio_) {
        //no se bien qué deberia haber aquí
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private Camino max(Vertice posicion) {
        ArrayList<Camino> listaCaminos=posicion.getListaCaminos();
        Camino max=listaCaminos.get(0);
        Camino temp;
        for(int i=1;i<listaCaminos.size();i++){
            temp=listaCaminos.get(i);
            if(temp.funcionObjetivo()>max.funcionObjetivo())
                max=temp;
        }
        return max;
    }

    private Camino min(Vertice posicion) {
        ArrayList<Camino> listaCaminos=posicion.getListaCaminos();
        Camino min=listaCaminos.get(0);
        Camino temp;
        for(int i=1;i<listaCaminos.size();i++){
            temp=listaCaminos.get(i);
            if(temp.funcionObjetivo()<min.funcionObjetivo())
                min=temp;
        }
        return min;
    }

    private Camino hallarAleatorio(Vertice posicion, float alfa, Camino beta, Camino tau) {
        //lista vacia
        Camino cam=null;
        ArrayList<Camino> candidatos=new ArrayList<>();
        int i;
        float f_beta=beta.funcionObjetivo();
        float f_tau=tau.funcionObjetivo();
        //llenamos lista
        ArrayList<Camino> listaCamino=posicion.getListaCaminos();
        for(i=0;i<listaCamino.size();i++){
            cam=listaCamino.get(i);
            if( (cam.funcionObjetivo()>=f_beta) && (cam.funcionObjetivo()<=(f_beta+alfa*(f_tau-f_beta))) )
                candidatos.add(listaCamino.get(i));
        }
        //elegimos aleatoriamente
        Random ran=new Random(System.currentTimeMillis());
        i=ran.nextInt(candidatos.size());
        //return  
        return candidatos.get(i);
    }
}
