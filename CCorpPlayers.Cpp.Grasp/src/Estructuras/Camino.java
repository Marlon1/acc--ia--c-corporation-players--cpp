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
    private float viento;


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
    public float getViento() {
        return viento;
    }
    public void setViento(float viento) {
        this.viento = viento;
    }
}
