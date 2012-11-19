/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import java.util.ArrayList;
import Estructuras.Vertice;


public class Solucion {
    private ArrayList<Vertice> vertices=new ArrayList<Vertice>();
    private double tiempo_total=0;

    static public Solucion mejorSolucion(Solucion A, Solucion B){
        
        if(A==null) return B;
        if(B==null) return A;
        
        Solucion s=new Solucion();
        if(A.tiempo_total<=B.tiempo_total){
            s.vertices=A.vertices;
            s.tiempo_total=A.tiempo_total;
        }
        else{
            s.vertices=B.vertices;
            s.tiempo_total=B.tiempo_total;
        }
        return s;
    }
    public void agregar(Vertice v){
        vertices.add(v);
        System.out.print(v.getNombre());
    }
    public void incrementarTiempo(double tiempo){
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
    public double getTiempo_total() {
        return tiempo_total;
    }

    /**
     * @param tiempo_total the tiempo_total to set
     */
    public void setTiempo_total(double tiempo_total) {
        this.tiempo_total = tiempo_total;
    }

    public void imprimir() {
        System.out.println();
        System.out.println("Tiempo total: "+tiempo_total);
//        for(int i=0;i<vertices.size();i++){
//            System.out.println(vertices.get(i).getNombre());
//        }
    }
}
