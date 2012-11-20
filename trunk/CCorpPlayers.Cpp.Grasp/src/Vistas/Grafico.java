/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Gestores.Lector;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author alulab11
 */
public class Grafico extends JFrame {
    public Grafico(){
    setSize(1000,700);
    setTitle("GRAFIQUITO :D");
    setVisible(true);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
     public void paint (Graphics g){
          super.paint(g);
          Lector lector= new Lector();
          int tam = lector.getV().size();
          for (int i=1; i<tam; i++){
                Integer nom = lector.getV().get(i).getNombre();
                Integer x = lector.getV().get(i).getX();
                Integer y = lector.getV().get(i).getY();
                g.drawString (Integer.toString(nom), x-1, y-1);
                g.fillOval(x, y, 10, 10);
          }
     }
    
}
