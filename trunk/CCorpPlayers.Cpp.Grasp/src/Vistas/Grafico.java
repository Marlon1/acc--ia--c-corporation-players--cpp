/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Algoritmos.GRASP;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author alulab11
 */
public class Grafico extends JFrame {

    public Grafico() {
        setSize(1000, 700);
        setTitle("GRAFIQUITO :D");
        setVisible(true);
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        super.paint(g);
        GRASP grasp=new GRASP();
        grasp.imprimirVertices();
        int tam = grasp.getV().size();
        for (int i = 0; i < tam; i++) {
            Integer nom = grasp.getV().get(i).getNombre();
            Integer x = grasp.getV().get(i).getX();
            Integer y = grasp.getV().get(i).getY();
            g.drawString(Integer.toString(nom), x - 1, y - 1);
            g.fillOval(x, y, 10, 10);
        }
        //super.repaint();
    }
}
