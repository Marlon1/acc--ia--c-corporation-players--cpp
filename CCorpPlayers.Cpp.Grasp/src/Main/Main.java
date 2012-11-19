package Main;

import Estructuras.Arista;
import Estructuras.Camino;
import Estructuras.Vertice;
import Gestores.GRASP;
import Gestores.Solucion;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        ArrayList<Vertice> V = new ArrayList<>();
        ArrayList<Arista> A = new ArrayList<Arista>();
        Vertice v1;
        try {
            BufferedReader br = new BufferedReader(new FileReader("datos.txt"));
            String linea = null;
            String numV;
            try {
                numV = br.readLine();
                String verticeInicio = br.readLine();
                int verticeIni = Integer.parseInt(verticeInicio) - 1;
                int numVertices = Integer.parseInt(numV);
                for (int i = 0; i < numVertices; i++) {
                    Vertice vertice = new Vertice(i);
                    V.add(vertice);
                }
                v1 = V.get(verticeIni);
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
                    A.add(a);

                    c = new Camino(a, V.get(vFinal), viento);
                    V.get(vInicial).agregarCamino(c);
                    if (direccion == 2) {
                        c = new Camino(a, V.get(vInicial), -viento);
                        V.get(vFinal).agregarCamino(c);
                    }
//                
//                    System.out.println("Vi es: " + vI);
//                    System.out.println("Vf es: " + vF);
//                    System.out.println("TiempoServ: " + tiemServ);
//                    System.out.println("TiempoCruce: " + tiemCruce);
//                    System.out.println("Viento: " + vient);
//                    System.out.println("Direccion es: " + direc);
                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        v1 = V.get(0);
        imprimir(V);
        
        GRASP grasp = new GRASP();
        Solucion sol = grasp.resolver(V, A, v1, 0.3);
        sol.imprimir();
    }
    static public void imprimir(ArrayList<Vertice> lista){
        Vertice v;
        Camino c;
        for(int i=0;i<lista.size();i++){
            v=lista.get(i);
            System.out.println(v.getNombre());
            for(int j=0;j<v.getListaCaminos().size();j++){
                c=v.getListaCaminos().get(j);
                System.out.println("    "+c.getArista().getNombre()+" "+c.getDestino().getNombre());
            }
        }
    }
}
