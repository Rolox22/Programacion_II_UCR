package Repaso_General;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @author "Rolando Murillo Aguirre"
 */
public class Iteradores_Ejm {

    public static void main(String[] args) {
        //Declaramos el ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Añadimos los números: 17, 21, 22, 23 a la lista");
        list.add(17);
        list.add(21);
        list.add(22);
        list.add(23);

        System.out.println("Imprimimos la lista");
        for (Integer numeros : list) {
            System.out.println(numeros);
        }

        System.out.println("\nAñadimos el número 28 a la lista");
        list.add(28);
        for (Integer numeros : list) {
            System.out.println(numeros);
        }
        
        System.out.println("Empleamos el Iterador");
        //Declaramos el Iterador
        ListIterator<Integer> it = list.listIterator();
        System.out.println("\nEmpleamos el método .next() para que la lista"
                + " empiece en el campo 1\n");
        it.next();
        System.out.println("\nAgregamos el número 45 el cual, se añadirá en el"
                + " campo 2 de la lista\n");
        it.add(45);
        System.out.println("Imprimimos la lista");
        for(Integer numeros: list){
            System.out.println(numeros);
        }
    }
}

