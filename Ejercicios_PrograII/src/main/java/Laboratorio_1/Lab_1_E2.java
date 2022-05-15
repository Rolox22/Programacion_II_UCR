package Laboratorio_1;

import Laboratorio_1.EstudianteLab_1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author "Rolando Murillo Aguirre"
 *
 * Según las API de JCF desarrolle los siguientes puntos: *
 *
 * 2. Cargar la lista de clase y realizar los siguientes procedimientos:
 *
 * a-) Cargar la Lista de un fichero y almacenar en un HashSet, determinar si
 * hay nombres completos repetidos.
 *
 * b-) Ordenar de forma ascendente la lista por nombre de estudiante y mostrar
 * la lista ordenada. Collections.sort().
 *
 * c-) Agregar un nuevo estudiante al final o al inicio. ArrayDeque o
 * LinkedList.
 *
 * d-) Remover, editar y buscar un estudiante en particular.
 *
 */
public class Lab_1_E2 {

    //Declaramos los array a utilizar
    static List<EstudianteLab_1> list;
    static HashSet hashSet;
    static LinkedList linkLis;

    //Declaramos el  método para entrada de datos
    static Scanner entry;

    //Declaramos las variables de uso en el programa
    static int busqueda;
    static int option1;
    static int option2;
    static int selection;
    static String carneBus;
    static String carneP;
    static String correoP;
    static String nameP;

    public static void main(String[] args) {
        do {
            entry = new Scanner(System.in);
            System.out.println("Ingrese el número de opción que desea"
                    + " realizar"
                    + "\n1. Cargar la Lista de un fichero y almacenar"
                    + " en un HashSet, determinar si hay nombres "
                    + "completos repetidos."
                    + "\n2. Ordenar de forma ascendente la lista por"
                    + " nombre de estudiante y mostrar la lista ordenada"
                    + ". Collections.sort()."
                    + "\n3. Agregar un nuevo estudiante al final o al"
                    + " inicio. ArrayDeque o LinkedList."
                    + "\n4. Remover, editar y buscar un estudiante en "
                    + "particular."
                    + "\n0. Salir");
            option1 = entry.nextInt();

            switch (option1) {

                case 1 -> {

                    File fileOp = abrirFichero();

                    list = new ArrayList<>(ficheroList(fileOp));

                    hashSet = new HashSet(list);

                    for (Object hs : hashSet) {
                        System.out.println(hs);
                    }

                    if (comprobacionHash(hashSet.size(), list.size()
                    ) == true) {
                        System.out.println("No se presentan nombres"
                                + " completos repetidos\n");
                    } else {
                        System.out.println("Existen nombres comple"
                                + "tos repetidos\n");
                    }
                }

                case 2 -> {
                    Collections.sort(list, (EstudianteLab_1 e1,
                            EstudianteLab_1 e2) -> e1.getName()
                            .compareTo(e2.getName()));
                    for (Object est : list) {
                        System.out.println(est);
                    }
                }

                case 3 -> {

                    entry = new Scanner(System.in);
                    System.out.println("AGREGAR NUEVO ESTUDIANTE\n");
                    linkLis = new LinkedList(list);

                    System.out.println("Ingrese el Nombre del estudiante en"
                            + " formato: 1°AP/2°AP/NOM");
                    nameP = entry.nextLine().toUpperCase();
                    System.out.println("Ingrese el Carné del estudiante");
                    carneP = entry.nextLine().toUpperCase();
                    System.out.println("Ingrese el Correo del estudiante");
                    correoP = entry.nextLine();

                    System.out.println("Desea agregar al inicio o al final"
                            + " de la lista: "
                            + "\n1. Inicio"
                            + "\n2. Final");
                    option2 = entry.nextInt();

                    if (option2 == 1) {
                        linkLis.addFirst(new EstudianteLab_1(nameP,
                                carneP, correoP));
                    } else {
                        linkLis.addLast(new EstudianteLab_1(nameP,
                                carneP, correoP));
                    }

                    for (Object listL : linkLis) {
                        System.out.println(listL);
                    }
                }

                case 4 -> {
                    entry = new Scanner(System.in);

                    System.out.println("Ingrese el carné del estudiante");
                    carneBus = entry.nextLine();

                    int val = busquedaCarne(carneBus, list);
                    if (val != 0) {
                        System.out.println("Para el estudiante: "
                                + list.get(val).getName()
                                + " Qué cambio desea realizar:"
                                + "\n1. Editar nombre"
                                + "\n2. Editar Carné"
                                + "\n3. Editar Correo");
                        selection = entry.nextInt();

                        switch (selection) {
                            case 1 -> {
                                entry = new Scanner(System.in);
                                System.out.println("Ingrese el nuevo nombre en"
                                        + " formato: 1°AP/2°AP/Nom");
                                String nameE = entry.nextLine();
                                list.get(val).setName(nameE);
                            }
                            case 2 -> {
                                entry = new Scanner(System.in);
                                System.out.println("Ingrese el nuevo Carné");
                                String carneE = entry.nextLine();
                                list.get(val).setCarne(carneE);
                            }
                            case 3 -> {
                                entry = new Scanner(System.in);
                                System.out.println("Ingrese el nuevo Correo");
                                String correoE = entry.nextLine();
                                list.get(val).setCorreo(correoE);
                            }
                            default -> {
                                System.out.println("Ingresó una opción"
                                        + " equivocada");
                            }
                        }
                        for (Object lisEd : list) {
                            System.out.println(lisEd);
                        }
                    } else {
                        System.out.println("Carné no registrado");
                    }
                }
                default -> {
                }
            }

        } while (option1 != 0);
    }

    /**
     * Creamos el método que nos permitirá abrir el ficher que con el cual se
     * pretende trabajar
     *
     * @return
     */
    private static File abrirFichero() {
        //Declaramos el archivo file donde se guardará el fichero
        File fileOpen = null;
        //Declaramos el JFileChooser que nos facilitará la busqueda del archivo
        JFileChooser fileO = new JFileChooser();

        //Agregamos un filtro de archivos especificos para mostrar
        fileO.setFileFilter(new FileNameExtensionFilter("Archivos txt",
                "txt", "TXT"));
        //Límitamos la lista de archivos que se pueden mostrar 
        fileO.setAcceptAllFileFilterUsed(false);

        //Variable de control para selección de archivos
        int control = fileO.showOpenDialog(fileO);

        if (control == JFileChooser.APPROVE_OPTION) {
            /*
            Instanciamos el archivo anteriormente declarado
            y asignamos el fichero selccionado
             */
            fileOpen = fileO.getSelectedFile();
        }

        return fileOpen;
    }

    /**
     * Método que permite la asignación de la lista con respecto al objeto
     * EstudianteLab_1
     *
     * @param fileOp
     * @return
     */
    private static ArrayList ficheroList(File fileOp) {
        List listaE = new ArrayList<EstudianteLab_1>();
        String aux;
        String name;
        String carne;
        String correo;

        try {
            BufferedReader bfr = new BufferedReader(new FileReader(fileOp));
            bfr.readLine();

            //Leemos el fichero para extraer los datos que ocupamos
            while ((aux = bfr.readLine()) != null) {
                //Extraemos el dato nombre de la lista
                name = (aux.substring(18, (Integer) aux.indexOf("  ")));
                //Extraemos el dato nombre de la lista
                carne = (aux.substring(11, 17));
                //Extraemos el dato nombre de la lista
                correo = (aux.substring((Integer) aux.indexOf("  "),
                        (Integer) aux.length() - 30));
                //Agregamos los datos que se extrajeron a la lista de tipo
                //EstudianteLab_1
                listaE.add(new EstudianteLab_1(name, carne, correo));
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }

        return (ArrayList) listaE;
    }

    /**
     * Método creado con el fin de dar respuesta si el HashSet presenta nombres
     * repetidos, gracias a la función del HashSet de no imprimir cosas
     * repetidas podemos llevar con un contador el número de elementos del
     * HashSet y compararlo con el tamaño de la lista original para así
     * verificar que no hay repetidos
     *
     * @param hasSize Tamaño del HashSet
     * @param listSize Tamaño de la lista original
     * @return
     */
    private static boolean comprobacionHash(int hasSize, int listSize) {

        boolean result = true; //Resultado de true o falsa segun la coincidencia

        if (listSize != hasSize) {
            result = false;
        }
        return result;
    }

    private static int busquedaCarne(String carneBus,
            List<EstudianteLab_1> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCarne().equalsIgnoreCase(carneBus)) {
                return i;
            }
        }
        return 0;
    }

}
