/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ccorpplayers.cpp.grasp;

/**
 *
 * @author Guti
 */
public class CCorpPlayersCppGrasp {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        String cad,parte1,parte2;
        cad = "Hola mundo";
        int i;
        for(i=0;cad.charAt(i)!=' ';i++);
        System.out.println(i);
        parte1=cad.substring(0, i);
        parte2=cad.substring(i+1, cad.length());
        System.out.println(parte1);
        System.out.println(parte2);
    }
}
