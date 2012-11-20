/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Estructuras.Arista;
import Estructuras.Camino;
import Estructuras.Vertice;
import Main.Main;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guti
 */
public class Lector {
    static private ArrayList<Vertice> V =null;
    static private ArrayList<Arista> A =null;
    static private Vertice v1=null;
    
    
    static public void leerArchivo() {
        V = new ArrayList<>();
        A = new ArrayList<Arista>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("datos.txt"));
            String linea = null;
            String numV;
            try {
                numV = br.readLine();
                String verticeInicio = br.readLine();
                int verticeIni = Integer.parseInt(verticeInicio)-1;
                int numVertices = Integer.parseInt(numV);
                for (int i = 1; i <= numVertices; i++) {
                    Vertice vertice = new Vertice(i);
                    getV().add(vertice);
                }
                v1 = getV().get(verticeIni);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            Camino c;
            Arista a;

            try {
                while ((linea = br.readLine()) != null) {
                    StringTokenizer mistokens = new StringTokenizer(linea, "  ");
                    String vI = mistokens.nextToken();
                    String vF = mistokens.nextToken();
                    String nomArista = mistokens.nextToken();
                    String tiemServ = mistokens.nextToken();
                    String tiemCruce = mistokens.nextToken();
                    String vient = mistokens.nextToken();
                    String direc = mistokens.nextToken();

                    int vInicial = Integer.parseInt(vI) - 1;
                    int vFinal = Integer.parseInt(vF) - 1;
                    Double tiempoServicio = Double.parseDouble(tiemServ);
                    Double tiempoCruce = Double.parseDouble(tiemCruce);
                    Double viento = Double.parseDouble(vient);
                    int direccion = Integer.parseInt(direc);


                    a = new Arista(nomArista, tiempoCruce, tiempoServicio);
                    getA().add(a);

                    c = new Camino(a, getV().get(vFinal), viento);
                    getV().get(vInicial).agregarCamino(c);
                    if (direccion == 2) {
                        c = new Camino(a, getV().get(vInicial), -viento);
                        getV().get(vFinal).agregarCamino(c);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the V
     */
    static public ArrayList<Vertice> getV() {
        return V;
    }

    /**
     * @return the A
     */
    static public ArrayList<Arista> getA() {
        return A;
    }

    /**
     * @return the v1
     */
    static public Vertice getVerticeInicial() {
        return v1;
    }
}
