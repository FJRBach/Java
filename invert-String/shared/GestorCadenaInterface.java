package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GestorCadenaInterface extends Remote {
    String invertirCadena(String cadena) throws RemoteException;
}
