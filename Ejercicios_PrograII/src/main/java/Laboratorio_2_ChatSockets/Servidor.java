/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Laboratorio_2_ChatSockets;

/**
 *
 * @author pablonoguera
 */
import java.io.*;
import java.net.*;
import java.util.*;


public class Servidor extends Thread
{
    public static ArrayList<String> nombres = new ArrayList();
  public static Vector usuarios = new Vector();
  public static void main (String args[])
  {
    ServerSocket sfd = null;
    try
    {
      sfd = new ServerSocket(8000);
    }
    catch (IOException ioe)
    {
      System.out.println("Comunicación rechazada."+ioe);
      System.exit(1);
    }
        while (true)
    {
      try
      {
        Socket nsfd = sfd.accept();
        DataInputStream FlujoLectura = new DataInputStream(new BufferedInputStream(nsfd.getInputStream()));
        String nombre = FlujoLectura.readUTF();
        System.out.println("Conexion aceptada de: "+ nombre);
	Flujo flujo = new Flujo(nsfd, nombre);
	Thread t = new Thread(flujo);
        t.start();
      }
      catch(IOException ioe)
      {
        System.out.println("Error: "+ioe);
      }
    }
  }
}


