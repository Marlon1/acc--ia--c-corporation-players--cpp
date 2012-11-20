/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.ArrayList;

/**
 *
 * @author Guti
 */
public class Vertice {
    private int nombre;
    private int x;
    private int y;
    private ArrayList<Camino> listaCaminos=new ArrayList<Camino>();
    
    
    public Vertice(int nombre){
        this.nombre=nombre;
    }
    public Vertice(int nombre,int x, int y){
        this.nombre=nombre;
        this.x=x;
        this.y=y;
    }
    public ArrayList<Camino> getListaCaminos() {
        return listaCaminos;
    }
    public void agregarCamino(Camino c){
        getListaCaminos().add(c);
    }


    /**
     * @param listaCaminos the listaCaminos to set
     */
    public void setListaCaminos(ArrayList<Camino> listaCaminos) {
        this.listaCaminos = listaCaminos;
    }

    /**
     * @return the nombre
     */
    public int getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
}
