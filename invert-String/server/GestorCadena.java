package server;

import shared.GestorCadenaInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GestorCadena extends UnicastRemoteObject 
    implements GestorCadenaInterface 
    {
    protected GestorCadena() 
        throws RemoteException 
        {
        super();
        }
    @Override
    public String invertirCadena(String cadena) throws RemoteException 
    {
        return new StringBuilder(cadena).reverse().toString();
    }
    }