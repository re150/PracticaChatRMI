
package main;

import Interfaces.MiInterfazRemota;
import Interfaces.InterfazCliente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
/**
 *
 * @author angel
 */
public class MiClaseRemota extends UnicastRemoteObject implements MiInterfazRemota{
    private List<InterfazCliente> clients;
    private Set<String> mensajesEnviados;
      
    
    public MiClaseRemota() throws RemoteException {
         clients = new ArrayList<>();
         mensajesEnviados = new HashSet<>();
    }
    
     public void registerClient(InterfazCliente client) throws RemoteException{
        clients.add(client);
       //  System.out.println(client);
    }
     
    public String poolMS(String  aux) throws RemoteException {
        
        //System.out.println(aux);   
        return aux;
    }

     public void SendMS(String mensaje) throws RemoteException {
        // System.out.println(mensaje);
        if (!mensajesEnviados.contains(mensaje)) {
            for (InterfazCliente client : clients) {
                client.recibirMS(mensaje);
               // System.out.println(client);
            }
            mensajesEnviados.add(mensaje);
        }
    }
}
