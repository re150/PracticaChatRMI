/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
import Interfaces.InterfazCliente;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author angel
 */
public interface MiInterfazRemotaPrivada extends Remote {
    void registerClient(InterfazCliente client) throws RemoteException; 
     void SendMS (String mensaje ) throws RemoteException ;
}
