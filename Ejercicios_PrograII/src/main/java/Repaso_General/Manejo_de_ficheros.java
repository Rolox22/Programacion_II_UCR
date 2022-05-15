package Repaso_General;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 * @author "Rolando Murillo Aguirre"
 */
public class Manejo_de_ficheros {

    public static void main(String[] args) throws IOException {
        //Declaramos el método para la entrada de datos por consola
        Scanner entry = new Scanner(System.in);

        //Declaramos las variables que se usaran en el programa
        int option1;
        do {
            System.out.println("""
                           Ingrese la opción que desea realizar 
                           1. Crear fichero
                           2. Escribir en un fichero
                           3. Leer fichero
                           0. Salir del programa""");
            option1 = entry.nextInt();

            switch (option1) {

                case 1 -> {
                    crearFichero();
                }
                case 2 -> {
                    editarFichero();
                }
                case 3 -> {
                    leerFichero();
                }
                default -> {
                }
            }
        } while (option1 != 0);
    }

    /**
     * Método que nos permitira crear un fichero en la ruta
     * seleccionada
     */
    private static void crearFichero() {

        //Declaramos el fileChooser
        JFileChooser rutaFile = new JFileChooser();

        //Agregamos el título de la ventana
        rutaFile.setDialogTitle("Seleccione el lugar para guardar el archivo");

        //Solicitamos el nombre para el archivo
        String filename = JOptionPane.showInputDialog(
                "Digite el nombre del archivo");
        rutaFile.setSelectedFile(new File(filename));

        //Ventana para guardar el archivo
        int comprobation = rutaFile.showSaveDialog(rutaFile);

        if (comprobation == JFileChooser.APPROVE_OPTION) {
            //Variable tipo file para almacenar la ruta de guardado
            File rutaF = rutaFile.getCurrentDirectory();
            //Este será el nuevo fichero que se creará
            File fichero = new File(rutaF, filename + ".txt");
            //Implementamos la captura de error
            try {
                //Se crea el fichero nuevo con el nombre y ruta especificada
                fichero.createNewFile();
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        } else {
            System.out.println("No entró");
        }
    }

    /**
     * Método que nos permite editar un fichero existente en el computador
     * @throws IOException 
     */
    private static void editarFichero() throws IOException {
        //Declaramos la ventana de ayuda JFileChooser
        JFileChooser openFi = new JFileChooser();

        //Variable de aprobación de apertura de archivo
        int aprobacion = openFi.showOpenDialog(openFi);

        if (aprobacion == JFileChooser.APPROVE_OPTION) {

            //Almacenamiento del fichero que se selecciona
            File fileO = openFi.getSelectedFile();

            try {

                //Declaramos el método para escribir en el fichero
                FileWriter wtr = new FileWriter(fileO, true);

                //Método para escribir con salto de línea en el fichero
                PrintWriter pwr = new PrintWriter(wtr);

                //Solicitamos el texto que se ingresará en el fichero
                String text = JOptionPane.showInputDialog("TEXTO DE INGRESO"
                        + " AL FICHERO", "Ingrese el texto que desea enviar"
                        + " al fichero");

                //Insertamos el texto en el fichero
                pwr.println(text);
                pwr.close(); //Cerramos el PrintWriter
                wtr.close(); //Cerramos el FileWriter

            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }

    /**
     * Método que nos permite abrir un fichero para su lectura
     */
    private static void leerFichero() {

        //Declaramos la ventana de ayuda java JFileChooser
        JFileChooser lectura = new JFileChooser();

        //Variable de control de aprobación de apertura de archivo
        int aprovation2 = lectura.showOpenDialog(lectura);

        if (aprovation2 == JFileChooser.APPROVE_OPTION) {

            //Almacenamiento del fichero que se selecciona
            File ficheroO = lectura.getSelectedFile();

            try {
                //Declaramos el método para la lectura del fichero
                BufferedReader bfr = new BufferedReader(new FileReader(ficheroO));
                String aux; //Variable auxiliar de lectura

                //Mientras la variable no tenga línea nula, continuará mostrando
                while ((aux = bfr.readLine()) != null) {
                    System.out.println(aux);
                }
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
}
