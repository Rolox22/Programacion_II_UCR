package Bingo_Final;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Enumeration;
import javax.swing.JOptionPane;

/**
 * @author "Rolando Murillo Aguirre"
 */
public class FlujoBingo extends Thread {

    Socket conection;
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;
    String nombre;

    public FlujoBingo(Socket conectionS, String nombreS) {

        this.nombre = nombreS;
        conection = conectionS;

        try {
            flujoEntrada = new DataInputStream(new BufferedInputStream(
                    conectionS.getInputStream()));

            flujoSalida = new DataOutputStream(new BufferedOutputStream(
                    conectionS.getOutputStream()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CATH:" + e.getLocalizedMessage(),
                    "Mensaje de CATCH", JOptionPane.WARNING_MESSAGE);
        }
    }

//    public void run() {
//
//        ServidorBingo.usuarios.add(new UsuarioBingo(this, this.nombre));
//        broadcast(nombre + " se ha conectado");
//
//        while (true) {
//            try {
//                String entrada = flujoEntrada.readUTF();
//                if (!entrada.equals("")) {
//                }
//                if (entrada.startsWith("carton")) {
//                    System.out.println("se escribio carton ");
//                    broadcast(entrada);
//                }
//                if (!flujoEntrada.readBoolean()) {
//
//                }
//
//            } catch (Exception e) {
//                ServidorBingo.usuarios.removeElement(this);
//                broadcast(nombre + "> se ha desconectado");
//                break;
//            }
//        }
//
//    }

    public void broadcast(String mensaje) {
        synchronized (ServidorBingo.usuarios) {

            Enumeration elements = ServidorBingo.usuarios.elements();

            while (elements.hasMoreElements()) {

                UsuarioBingo usuario = (UsuarioBingo) elements.nextElement();

                FlujoBingo flujo = (FlujoBingo) usuario.getFlujoBingo();

                try {

                    synchronized (flujo.flujoSalida) {
                        flujo.flujoSalida.writeUTF(mensaje);
                        flujo.flujoSalida.flush();
                    }

                } catch (Exception e) {
                    System.out.println("Error: " + e.getLocalizedMessage());
                }
            }
        }
    }

    public void broadcast(String mensaje, UsuarioBingo userr) {
        synchronized (ServidorBingo.usuarios) {
            Enumeration elements = ServidorBingo.usuarios.elements();
            while (elements.hasMoreElements()) {
                UsuarioBingo usuario = (UsuarioBingo) elements.nextElement();
                FlujoBingo flujo = (FlujoBingo) usuario.getFlujoBingo();
                try {
                    synchronized (flujo.flujoSalida) {
                        flujo.flujoSalida.writeUTF(mensaje);
                        flujo.flujoSalida.flush();
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e);
                }
            }
        }
    }

}
