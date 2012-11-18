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
    private ArrayList<Camino> listaCaminos=new ArrayList<Camino>();
    
    
    public ArrayList<Camino> getListaCaminos() {
        return listaCaminos;
    }
    public void agregarCamino(Camino c){
        listaCaminos.add(c);
    }
}
