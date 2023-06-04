/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import Interfaces.InterfazCliente;
import Interfaces.MiInterfazRemotaPrivada;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author angel
 */
public class MiclassRemotaPunto extends UnicastRemoteObject implements MiInterfazRemotaPrivada {

    public InterfazCliente client;
   
    
    public MiclassRemotaPunto () throws RemoteException {
        client = null;
    }
    
   public void registerClient(InterfazCliente client1) throws RemoteException{
      System.out.println(client);
      client = client1;
    }
   
   public void SendMS(String mensaje ) throws RemoteException {
          System.out.println(mensaje);
           if (client != null) {
            client.recibirMS(mensaje);
        } else {
            System.out.println("No hay cliente destinatario registrado.");
        }
    }
  
   
}
