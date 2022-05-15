package Repaso_General;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author "Rolando Murillo Aguirre"
 */
public class ListaMetodos {

    public static void main(String... xx) {
        List<String> lista = new ArrayList<>();
        //Agregamos a la lista
        lista.add("mango");
        lista.add("pera");
        lista.add("anona");
        lista.add("pera");
        lista.add("anona");
        System.out.println("Lista: " + lista);

        //Size de la lista
        System.out.println("Lista size: " + lista.size());

        //Obtener un elemento de la lista
        System.out.println("Lista posición 0: " + lista.get(0));

        //Eliminar un elemento de la lista
        lista.remove(lista.size() - 1); //borra por posición
        lista.remove("pera"); //borra primer coincidencia
        System.out.println("Lista: " + lista);

        //Buscar o contener elemento, primera coincidencia
        System.out.println("Contiene elemento?: " + lista.contains("anona"));

        //Modificar un elemento de una posicion de la lista
        lista.set(1, "pera"); //Modificamos anona por pera
        lista.set(2, "anona"); //Modificamos pera por anona

        //Seleccionar una parte de la lista por rango
        System.out.println("Lista posicion 1 y 2: " + lista.subList(1, 3)); //desplegamos pera y anona

        //Validar si lista esta vacia o no
        System.out.println("Lista vacía?: " + lista.isEmpty());

        //Recorrer la lista ITERATOR
        Iterator i = lista.iterator();
        System.out.println("Listado mediante ITERATOR");
        while (i.hasNext()) {
            System.out.println("Elemento " + i.next());
        }
        //Recorrer la lista FOR
        System.out.println("Listado mediante FOR");
        for (int j = 0; j < lista.size(); j++) {
            System.out.println("Elemento " + lista.get(j));
        }
        //Recorrer la lista for-each
        System.out.println("Listado mediante FOR-EACH");
        for (String elemento : lista) {
            System.out.println("Elemento " + elemento);
        }
        //Recorrer la lista forEach
        System.out.println("Listado mediante forEach");
        lista.forEach((x) -> {
            System.out.println("Elemento " + x);
        });

        //Ordenar una lista de forma ascendente con Collections
        Collections.sort(lista);
        System.out.println("Lista ordenada ascendentemente: " + lista);

        //Ordenar lista descendentemente con Collections
        Collections.sort(lista, Collections.reverseOrder());
        System.out.println("Lista ordenada ascendentemente: " + lista);

        //Ordenar una lista de forma ascendente con sort de la lista y Comparator
        lista.sort(Comparator.naturalOrder());
        System.out.println("Lista ordenada ascendentemente Comparator: " + lista);

        //Ordenar lista descendentemente con sort de la lista y Comparator
        lista.sort(Comparator.reverseOrder());
        System.out.println("Lista ordenada ascendentemente Comparator: " + lista);

        //Borrar o limpiar toda la lista de sus elementos
        lista.clear();
        System.out.println("Lista vacia: " + lista);

    }
}
