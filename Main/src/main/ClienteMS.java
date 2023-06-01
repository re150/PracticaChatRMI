/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author angel
 */
public class ClienteMS extends UnicastRemoteObject implements InterfazCliente {
    
   public ClienteMS () throws RemoteException  {
   
   }
    
    public void recibirMS (String mensaje) throws RemoteException {
        System.out.println(mensaje);
     }
}
