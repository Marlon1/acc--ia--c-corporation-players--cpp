/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Estructuras.Arista;
import java.util.ArrayList;

/**
 *
 * @author Guti
 */
public class GestorVertice {
    private ArrayList<Arista> listaAristas = new ArrayList<>();


    public ArrayList<Arista> getListaAristas() {
        return listaAristas;
    }
    public void setListaAristas(ArrayList<Arista> listaAristas) {
        this.listaAristas = listaAristas;
    }    
    public void agregarArista(Arista a){
        listaAristas.add(a);
    }
}
