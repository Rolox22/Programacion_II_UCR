package Laboratorio_1;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author "Rolando Murillo Aguirre"
 *
 * 1. Crear un procedimiento que determine si una frase es un Palindromo,
 * implementando la API Stack.
 */
public class Lab_1_E1 {

    //Declaramos las variables de uso en el programa
    static int option;
    static String text;

    //Declaramos los Stack que se utilizaran
    static Stack<Character> pila = new Stack<>();
    static Stack<Character> pilaux = new Stack<>();

    //Declaramos los array a utilizar
    static char[] textChar;

    //Declaramos el  método para entrada de datos
    static Scanner entryP = new Scanner(System.in);

    public static void main(String[] args) {

        //Instanciamos el método de entrada de datos por consola
        entryP = new Scanner(System.in);

        //Solicitamos la palabra o frase a comprobar
        System.out.println("Ingrese la palabra o frase a analizar");
        //Capturamos la palabra o frase
        text = entryP.nextLine();

        /**
         * Convertimos la palabra o frase en un vector de chars el mismo no
         * contiene espacios y todo está en letras minúculas
         */
        textChar = text.replaceAll(" ", "").toLowerCase()
                .toCharArray();

        //Agregamos el ArrayChart a las pilas
        for (char aChar : textChar) {
            pila.push(aChar);
            pilaux.push(aChar);
        }

        System.out.println("La palabra o frase: " + text
                + " ,para palindromo es: "
                + palindromoStack(pila, pilaux));

        pila.clear(); // Eliminamos los datos de la pila
        pilaux.clear(); // Eliminamos los datos de la pila 

    }

    /**
     * Metodo para determnar si la frase o palabra es un palindromo se reciben
     * las dos pilas por parámetro, consiste en comparar dos las pilas pero una
     * se imprime de atras hacia adelante para comparar si coinciden sus
     * caracteres
     *
     * @param pila
     * @param pilaux
     * @return
     */
    private static boolean palindromoStack(Stack<Character> pila,
            Stack<Character> pilaux) {

        while (pila.empty() != true) {
            for (char pl : pilaux) {
                if (pl != pila.pop()) {
                    return false;
                }
            }
        }
        return true;
    }
}
