/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import java.util.ArrayList;
import Estructuras.Vertice;


public class Solucion {
    private ArrayList<Vertice> vertices;
    private float tiempo_total=0;

    
    public void add(Vertice v){
        vertices.add(v);
    }
    public void incrementarTiempo(float tiempo){
        tiempo_total+=tiempo;
    }
    /**
     * @return the vertices
     */
    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    /**
     * @param vertices the vertices to set
     */
    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    /**
     * @return the tiempo_total
     */
    public float getTiempo_total() {
        return tiempo_total;
    }

    /**
     * @param tiempo_total the tiempo_total to set
     */
    public void setTiempo_total(float tiempo_total) {
        this.tiempo_total = tiempo_total;
    }
}