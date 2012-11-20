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
    Random ran=new Random(System.currentTimeMillis());        

    public Solucion resolver(ArrayList<Vertice> V_, ArrayList<Arista> A_,  Vertice inicio_,double alfa){
        Camino beta,tau;        
        Camino camino;
        Arista arista;
        
        //no se si esto va:
        inicializar2(A_,V_,inicio_); //copiar
        //Main.Main.imprimir(V);
        
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
                A.remove(arista);
                arista.setRecorrido(true);
            }
        }
        return S;
    }

    private void inicializar(ArrayList<Arista> A, ArrayList<Vertice> V, Vertice inicio) {

        this.inicio=inicio;
        
        this.A=new ArrayList<Arista>();
        Arista a,temp;
        for(int i=0;i<A.size();i++){
            temp=A.get(i);
            a=new Arista(temp.getNombre(), temp.getTiempoCruce(), temp.getTiempoServicio());
            this.A.add(a);
        }
        
        this.V=new ArrayList<Vertice>();
        Vertice v;
        for(int i=0;i<V.size();i++){
            v=new Vertice(V.get(i).getNombre());
            this.V.add(v);
        }
        ArrayList<Camino> caminos;
        Camino c,tempc;
        
        for(int i=0;i<V.size();i++){
            caminos=V.get(i).getListaCaminos();
            for(int j=0;j<caminos.size();j++){
                tempc=caminos.get(j);
                a=this.A.get(A.indexOf(tempc.getArista()));
                v=this.V.get(V.indexOf(tempc.getDestino()));
                c=new Camino(a, v, tempc.getViento());
                this.V.get(i).agregarCamino(c);
            }           
        }
        
    }
    private void inicializar2(ArrayList<Arista> A, ArrayList<Vertice> V, Vertice inicio) {
        //no se bien qué deberia haber aquí
        this.A=A;
        this.V=V;
        this.inicio=inicio;
    }
    private Camino max(Vertice posicion) {
        ArrayList<Camino> listaCaminos=posicion.getListaCaminos();
        if(listaCaminos.size()==0)
            System.out.println("Error Vertice: " + posicion.getNombre());
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

    private Camino hallarAleatorio(Vertice posicion, double alfa, Camino beta, Camino tau) {
        //lista vacia
        Camino cam=null;
        ArrayList<Camino> candidatos=new ArrayList<>();
        int i;
        double f_beta=beta.funcionObjetivo();
        double f_tau=tau.funcionObjetivo();
        //llenamos lista
        ArrayList<Camino> listaCamino=posicion.getListaCaminos();
        double lim_inf=f_beta-alfa*(f_beta-f_tau);
        double lim_sup=f_beta;
        double f_cam;
        for(i=0;i<listaCamino.size();i++){
            cam=listaCamino.get(i);
            f_cam=cam.funcionObjetivo();
            if( (f_cam<=lim_sup) && (f_cam>=lim_inf) )
                candidatos.add(listaCamino.get(i));
        }
        //elegimos aleatoriamente
        
        i=ran.nextInt(candidatos.size());
        //return  
        return candidatos.get(i);
    }
    public void ejecutar() {
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
