package server;

import shared.SaludadorInterface;

public class Saludador 
    implements SaludadorInterface 
{
    @Override
    public String diHola()
        throws java.rmi.RemoteException
    {
        return "Hola";
    }

    @Override
    public String diHola(String nombre)
        throws java.rmi.RemoteException
    {
        return "Hola, " + nombre;
    }
}
