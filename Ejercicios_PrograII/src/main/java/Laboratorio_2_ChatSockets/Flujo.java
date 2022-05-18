/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Laboratorio_2_ChatSockets;

/**
 *
 * @author pablonoguera
 */
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Flujo extends Thread
{
  Socket nsfd;
  DataInputStream FlujoLectura;
  DataOutputStream FlujoEscritura;
  String nombre;
  public Flujo (Socket sfd, String nombre)
  {
      this.nombre = nombre;
    nsfd = sfd;
    try
    {
      FlujoLectura = new DataInputStream(new BufferedInputStream(sfd.getInputStream()));
      FlujoEscritura = new DataOutputStream(new BufferedOutputStream(sfd.getOutputStream()));
    }

catch(IOException ioe)
    {
      System.out.println("IOException(Flujo): "+ioe);
    }
  }

  public void run()
  {
    broadcast(nombre +"> se ha conectado");
    Servidor.usuarios.add ((Object) this);
    
    Servidor.nombres.add(nombre);
    broadcast(nombre + " se ha conectado");
    while(true)
    {
      try
      {
        String linea = FlujoLectura.readUTF();
        if (!linea.equals(""))
	{
          linea = nombre +"> "+ linea;
	  broadcast(linea);
	}
      }
catch(IOException ioe)
      {
	Servidor.usuarios.removeElement(this);
	broadcast(nombre+"> se ha desconectado");
	break;
      }
    }
  }
  
  public void broadcast(String mensaje)
  {
    synchronized (Servidor.usuarios)
    {
      Enumeration e = Servidor.usuarios.elements();
      while (e.hasMoreElements())
      {
	Flujo f = (Flujo) e.nextElement();
try
	{
          synchronized(f.FlujoEscritura)
	  {
            f.FlujoEscritura.writeUTF(mensaje);
	    f.FlujoEscritura.flush();
	  }
        }
	catch(IOException ioe)
	{
	  System.out.println("Error: "+ioe);
	}
      }
    }
  }
}
