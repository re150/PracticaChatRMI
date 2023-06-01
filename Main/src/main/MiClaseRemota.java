
package main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author angel
 */
public class MiClaseRemota extends UnicastRemoteObject implements MiInterfazRemota{
    private List<InterfazCliente> clients;
    
    public MiClaseRemota() throws RemoteException {
         clients = new ArrayList<>();
    }
    
     public void registerClient(InterfazCliente client) throws RemoteException{
        clients.add(client);
    }
     
    public String poolMS(String  aux) throws RemoteException {
        
        //System.out.println(aux);   
        return aux;
    }

     public void SendMS (String mensaje) throws RemoteException {
        // System.out.println(mensaje);
         for (InterfazCliente client: clients ) {
             client.recibirMS(mensaje);
         }
         
    }
}
