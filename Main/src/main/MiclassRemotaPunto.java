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
    private InterfazCliente cliente2;
    
    public MiclassRemotaPunto () throws RemoteException {
        client = null;
        cliente2 = null;
    }
    
   public void registerClient(InterfazCliente client1) throws RemoteException{
      System.out.println(client);
      if(client == null){
          client = client1;
      }else if(cliente2 == null){
          cliente2 = client1;
      } else {
           System.out.println("No se pueden registrar más clientes");
      }
      
    }
   
   public void SendMS(String mensaje ) throws RemoteException {
          System.out.println(mensaje);
           if (client != null) {
            client.recibirMS(mensaje);
            cliente2.recibirMS(mensaje);
        } else {
            System.out.println("No hay cliente destinatario registrado.");
        }
    }
  
   
}
