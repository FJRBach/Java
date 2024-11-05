package server;

import shared.GestorCadenaInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            GestorCadena gestorCadena = new GestorCadena();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("GestorCadena", gestorCadena);
            System.out.println("Servidor RMI listo y esperando solicitudes...");
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
