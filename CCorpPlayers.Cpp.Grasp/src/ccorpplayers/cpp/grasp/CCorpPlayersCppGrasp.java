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
        String cad;
        cad = "Hola mundo";
        int i;
        for(i=0;cad.charAt(i)!=' ';i++);
        System.out.println(i);
        cad=cad.substring(0, i);
        System.out.println(cad);
    }
}
