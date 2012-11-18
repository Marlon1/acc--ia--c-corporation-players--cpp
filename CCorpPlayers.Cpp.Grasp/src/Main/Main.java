package Main;

import Estructuras.Vertice;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String cad,parte1,parte2;
        cad = "Hola mundo";
        int i;
        for(i=0;cad.charAt(i)!=' ';i++);
        System.out.println(i);
        parte1=cad.substring(0, i);
        parte2=cad.substring(i+1, cad.length());
        System.out.println(parte1);
        System.out.println(parte2);
        String ruta=System.getProperty("user.dir")+"/Input.txt";
        System.out.println("Working Directory = " + ruta );
        //InputStream input = Files.newInputStream(ruta, CREATE);
        
        
        
    }
}
