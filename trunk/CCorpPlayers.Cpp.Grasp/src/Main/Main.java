package Main;

import Estructuras.Vertice;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //leerDatos();
        //Construccion();
        //mejora();
        //imprimir resultado;
        int i;
        Random ran=new Random(System.currentTimeMillis());
        for(int j=0;j<100;j++){
            i=ran.nextInt(4+1);
            System.out.println(i);
        }
    }
}
