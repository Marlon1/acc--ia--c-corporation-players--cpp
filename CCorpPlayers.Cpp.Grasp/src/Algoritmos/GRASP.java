package Algoritmos;

import Estructuras.Solucion;
import Estructuras.Arista;
import Estructuras.Camino;
import Estructuras.Vertice;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GRASP {

    private ArrayList<Arista> A;
    private ArrayList<Vertice> V;
    private Solucion S;
    private Vertice inicio;
    Random ran = new Random(System.currentTimeMillis());

    public void leerArchivo() {
        V = new ArrayList<>();
        A = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("datos.txt"));
            String linea;
            String numV;
            try {
                numV = br.readLine();
                String verticeInicio = br.readLine();
                int verticeIni = Integer.parseInt(verticeInicio);
                int numVertices = Integer.parseInt(numV);
                for (int i = 0; i < numVertices; i++) {
                    Vertice vertice = new Vertice(i);
                    V.add(vertice);
                }
                inicio = V.get(verticeIni);
            } catch (IOException ex) {
                Logger.getLogger(GRASP.class.getName()).log(Level.SEVERE, null, ex);
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

                    int vInicial = Integer.parseInt(vI);
                    int vFinal = Integer.parseInt(vF);
                    Double tiempoServicio = Double.parseDouble(tiemServ);
                    Double tiempoCruce = Double.parseDouble(tiemCruce);
                    Double viento = Double.parseDouble(vient);
                    int direccion = Integer.parseInt(direc);


                    a = new Arista(nomArista, tiempoCruce, tiempoServicio, direccion);
                    getA().add(a);

                    c = new Camino(a, getV().get(vFinal), viento);
                    getV().get(vInicial).agregarCamino(c);
                    if (direccion == 2) {
                        c = new Camino(a, getV().get(vInicial), -viento);
                        getV().get(vFinal).agregarCamino(c);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(GRASP.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GRASP.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            BufferedReader ar = new BufferedReader(new FileReader("vertices.txt"));
            String linea;
            String x, y, nombre;
            try {
                while ((linea = ar.readLine()) != null) {
                    StringTokenizer mistokens = new StringTokenizer(linea, "  ");
                    nombre = mistokens.nextToken();
                    x = mistokens.nextToken();
                    y = mistokens.nextToken();

                    int nom = Integer.parseInt(nombre);
                    int vX = Integer.parseInt(x);
                    int vY = Integer.parseInt(y);


                    getV().get(nom).setX(vX);
                    getV().get(nom).setY(vY);

                }
            } catch (IOException ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        //imprimirVertices();
    }

    public Solucion construirSolucion(double alfa) {
        Camino beta, tau;
        Camino camino;
        Arista arista;

        Vertice posicion = inicio;
        S = new Solucion();
        getS().setTiempo_total(0);
        getS().agregar(inicio);
        int i = 0;
        while (!((posicion == inicio) && A.isEmpty())) {
            beta = max(posicion);
            tau = min(posicion);

            camino = hallarAleatorio(posicion, alfa, beta, tau);
            posicion = camino.getDestino();

            getS().agregar(posicion);
            getS().incrementarTiempo(camino.getTiempo());
            arista = camino.getArista();
            if (!arista.isRecorrido()) {
                getA().remove(arista);
                arista.setRecorrido(true);
            }
//            if(i++==1000){
//                imprimirAristas();
//                i=0;
//            }
        }
        return getS();
    }

    {/* private void inicializar(ArrayList<Arista> A, ArrayList<Vertice> V, Vertice inicio) {

         this.inicio = inicio;

         this.A = new ArrayList<>();
         Arista a, temp;
         for (int i = 0; i < A.size(); i++) {
         temp = A.get(i);
         a = new Arista(temp.getNombre(), temp.getTiempoCruce(), temp.getTiempoServicio());
         this.getA().add(a);
         }

         this.V = new ArrayList<>();
         Vertice v;
         for (int i = 0; i < V.size(); i++) {
         v = new Vertice(V.get(i).getNombre());
         this.getV().add(v);
         }
         ArrayList<Camino> caminos;
         Camino c, tempc;

         for (int i = 0; i < V.size(); i++) {
         caminos = V.get(i).getListaCaminos();
         for (int j = 0; j < caminos.size(); j++) {
         tempc = caminos.get(j);
         a = this.getA().get(A.indexOf(tempc.getArista()));
         v = this.getV().get(V.indexOf(tempc.getDestino()));
         c = new Camino(a, v, tempc.getViento());
         this.getV().get(i).agregarCamino(c);
         }
         }

         }

         private void inicializar2(ArrayList<Arista> A, ArrayList<Vertice> V, Vertice inicio) {
         //no se bien qué deberia haber aquí
         this.A = A;
         this.V = V;
         this.inicio = inicio;
         }*/

    }

    private Camino max(Vertice posicion) {
        ArrayList<Camino> listaCaminos = posicion.getListaCaminos();
        if (listaCaminos.isEmpty()) {
            System.out.println("Error Vertice: " + posicion.getNombre());
        }
        Camino max = listaCaminos.get(0);
        Camino temp;
        for (int i = 1; i < listaCaminos.size(); i++) {
            temp = listaCaminos.get(i);
            if (temp.funcionObjetivo() > max.funcionObjetivo()) {
                max = temp;
            }
        }
        return max;
    }

    private Camino min(Vertice posicion) {
        ArrayList<Camino> listaCaminos = posicion.getListaCaminos();
        Camino min = listaCaminos.get(0);
        Camino temp;
        for (int i = 1; i < listaCaminos.size(); i++) {
            temp = listaCaminos.get(i);
            if (temp.funcionObjetivo() < min.funcionObjetivo()) {
                min = temp;
            }
        }
        return min;
    }

    private Camino hallarAleatorio(Vertice posicion, double alfa, Camino beta, Camino tau) {
        //lista vacia
        Camino cam;
        ArrayList<Camino> candidatos = new ArrayList<>();
        //imprimeCaminos(posicion);
        int i;
        double f_beta = beta.funcionObjetivo();
        double f_tau = tau.funcionObjetivo();
        //llenamos lista
        ArrayList<Camino> listaCamino = posicion.getListaCaminos();
        double lim_inf = f_beta - alfa * (f_beta - f_tau);
        double lim_sup = f_beta;
        double f_cam;
        for (i = 0; i < listaCamino.size(); i++) {
            cam = listaCamino.get(i);
            f_cam = cam.funcionObjetivo();
            if ((f_cam <= lim_sup) && (f_cam >= lim_inf)) {
                candidatos.add(listaCamino.get(i));
            }
        }
        //elegimos aleatoriamente

        i = ran.nextInt(candidatos.size());
        //return  
        return candidatos.get(i);
    }

    public Solucion ejecutar(double alfa, int rep) {
        Solucion mejor_sol = null;
        for (int k = 0; k < rep; k++) {
            leerArchivo();
            Solucion sol = construirSolucion(alfa);
            if (sol.getTiempo_total() >= 0.001) {
                //sol.imprimir();
                mejor_sol = Solucion.mejorSolucion(mejor_sol, sol);
            }
        }
//        System.out.println();
//        leerArchivo();
//        imprimirVertices();
        System.out.println("Mejor Solucion (alfa: " + alfa + ")");
        mejor_sol.imprimir();
        return mejor_sol;
    }

    public void imprimirCaminos(Vertice posicion) {
        System.out.println("Vertice: " + posicion.getNombre());
        ArrayList<Camino> c = posicion.getListaCaminos();
        for (int i = 0; i < c.size(); i++) {
            System.out.println("   " + c.get(i).getArista().getNombre() + " -> " + c.get(i).getDestino().getNombre());
        }
    }

    public void imprimirVertices() {
        System.out.println();
        System.out.println("Lista de Vertices: ");
        for (int i = 0; i < getV().size(); i++) {
            imprimirCaminos(getV().get(i));
        }
    }

    public ArrayList<Arista> getA() {
        return A;
    }

    public ArrayList<Vertice> getV() {
        return V;
    }

    public Solucion getS() {
        return S;
    }

    private void imprimirAristas() {
        System.out.println("Lista de Aristas: ");
        for (int i = 0; i < A.size(); i++) {
            System.out.println(A.get(i).getNombre());
        }
    }
}
