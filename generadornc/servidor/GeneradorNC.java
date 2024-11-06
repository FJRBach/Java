package servidor;

import shared.IGeneradorNC;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class GeneradorNC extends UnicastRemoteObject implements IGeneradorNC 
{
    private HashMap<String, Integer> contadores;

    public GeneradorNC() throws RemoteException
    {
        super();
        contadores = new HashMap<>();
    }

    @Override
    public String generarNC(int anio, int tec) throws RemoteException {
        String key = anio + "-" + tec;
        int consecutivo = contadores.getOrDefault(key, 0) + 1;
        contadores.put(key, consecutivo);
        
        String numeroControl = String.format("%02d%02d%04d", anio % 100, tec, consecutivo);
        return numeroControl;
    }
}