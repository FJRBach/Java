package client;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import shared.SaludadorInterface;

public class Cliente {
    public static void main(String[] args) 
    {
        try 
        {
            Registry registro = LocateRegistry.getRegistry(1099);
            SaludadorInterface saludador = (SaludadorInterface)registro.lookup("Saludador");
            System.out.println(saludador.diHola());
            System.out.println("Presionar ENTER para continuar...");
            System.in.read();
        }catch (RemoteException rex)
        {
            System.err.println(rex.getMessage());
        }catch (NotBoundException nbex)
        {
            System.err.println(nbex.getMessage());
        }catch(IOException ioex)
        {
            System.err.println(ioex.getMessage());
        }   
    }
}
