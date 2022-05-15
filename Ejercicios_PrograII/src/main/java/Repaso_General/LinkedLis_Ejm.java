package Repaso_General;

import java.util.LinkedList;

/**
 * @author "Rolando Murillo Aguirre"
 *
 * El almacena sus artículos en "contenedores". La lista tiene un vínculo al
 * primer contenedor y cada contenedor tiene un vínculo al siguiente contenedor
 * de la lista. Para agregar un elemento a la lista, el elemento se coloca en un
 * nuevo contenedor y ese contenedor se vincula a uno de los otros contenedores
 * de la lista.LinkedList
 *
 * VENTAJAS DESVENTAJA Están ordenadas(Collection.sort()) Bajo rendimiento
 * Añadir/Eliminar elementos sin restricción ListIterator modifica en cualquier
 * dirección
 *
 * Method           Description
 * addFirst()       Agrega un elemento al principio de la lista.
 * addLast()        Agregar un elemento al final de la lista. 
 * removeFirst()    Eliminar un elemento del principio de la lista. 
 * removeLast()     Eliminar un elemento del final de la lista. 
 * getFirst()       Obtener el elemento al principio de la lista.
 * getLast()        Obtener el elemento al final de la lista
 *
 */
public class LinkedLis_Ejm {

    public static void main(String[] args) {
        /**
         * Declaración del linkedList se puede parametrizar con lo que se desee
         * int, double, chart o bien con algún objeto en particular
         */
        LinkedList<String> ejLinkedNombres = new LinkedList<>();

        //Añadimos objetos al LinkedList
        ejLinkedNombres.add("Juan");
        ejLinkedNombres.add("Rosario");
        ejLinkedNombres.add("Mario");
        ejLinkedNombres.add("Luis");
        ejLinkedNombres.add("Fabiana");

        System.out.println("Cantidad de elementos del LinkedList: \n"
                + ejLinkedNombres.size());

        //Imprimimos el LinkedList de puño
        System.out.println("\nImprimir forma 1: \n"
                + ejLinkedNombres);

        //Imprimir el LinkedList uno a uno
        System.out.println("\nImprimir forma 2: ");
        for (String nombre : ejLinkedNombres) {
            System.out.println(nombre);
        }

        System.out.println("\nAñadimos Byron a la lista por default se agraga al final");
        ejLinkedNombres.add("Byron");
        for (String nombre : ejLinkedNombres) {
            System.out.println(nombre);
        }

        System.out.println("\nAñadimos el nombre Fernanda al inicio");
        ejLinkedNombres.addFirst("Fernanda");
        for (String nombre : ejLinkedNombres) {
            System.out.println(nombre);
        }

        System.out.println("\nRemovemos el elemento 5 de la lista");
        ejLinkedNombres.remove(4);
        for (String nombre : ejLinkedNombres) {
            System.out.println(nombre);
        }

        System.out.println("\nRemovemos el ultimo elemento");
        ejLinkedNombres.removeLast();
        for (String nombre : ejLinkedNombres) {
            System.out.println(nombre);
        }

        System.out.println("\nRemovemos el primer elemento");
        ejLinkedNombres.removeFirst();
        for (String nombre : ejLinkedNombres) {
            System.out.println(nombre);
        }

        System.out.println("\nBorramos los elementos del LinkedList");
        ejLinkedNombres.clear();

        if (ejLinkedNombres.isEmpty()) {
            System.out.println("La lista está vacía");
        } else {
            for (String nombre : ejLinkedNombres) {
                System.out.println(nombre);
            }
        }
    }
}
