/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Guti
 */
public class Camino {
    private Arista arista;
    private Vertice destino;
    private double viento;
    
    
    public Camino(Arista a, Vertice d, double v){
        this.arista=a;
        this.destino=d;
        this.viento=v;
    }
    public Arista getArista() {
        return arista;
    }
    public void setArista(Arista arista) {
        this.arista = arista;
    }
    public Vertice getDestino() {
        return destino;
    }
    public void setDestino(Vertice destino) {
        this.destino = destino;
    }
    public double getViento() {
        return viento;
    }
    public void setViento(double viento) {
        this.viento = viento;
    }
    public double getTiempo(){
        if(arista.isRecorrido()) return arista.getTiempoCruce()*(1+viento);
        else return (arista.getTiempoServicio() + arista.getTiempoCruce()*(1+viento));
    }
    public double funcionObjetivo(){
        int i;
        if(arista.isRecorrido())
            i=0;
        else
            i=1;
        return i*(arista.getTiempoServicio() + arista.getTiempoCruce()*(1+viento));
        
    }
}
