package Vistas;

import Algoritmos.GRASP;
import Estructuras.Camino;
import Estructuras.Vertice;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author alulab11
 */
public class Grafico extends JFrame {

    public Grafico() {
        setSize(1000, 800);
        setTitle("GRAFIQUITO :D");
        setVisible(true);
        
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        super.paint(g);
        GRASP grasp=new GRASP();
        grasp.leerArchivo();
        grasp.imprimirVertices();
        int tam = grasp.getV().size();
        for (int i = 0; i < tam; i++) {
            Vertice vertice;
            vertice = grasp.getV().get(i);
            int nom = vertice.getNombre();
            int x = vertice.getX();
            int y = vertice.getY();
            g.setColor(Color.black);
            g.drawString(Integer.toString(nom), x - 1, y - 1);
            g.fillOval(x, y, 10, 10);
            int tamCaminos = vertice.getListaCaminos().size();
            for (int j=0; j<tamCaminos; j++){
                Camino camino;
                camino = vertice.getListaCaminos().get(j);
                int x2 = camino.getDestino().getX();
                int y2 = camino.getDestino().getY();
                g.setColor(Color.black);
                if (camino.getArista().getDireccion() == 2) g.setColor(Color.red);
                g.drawLine(x+5, y+5, x2+5, y2+5);
                
            }
        }
        //super.repaint();
    }
}