package servidor;

import shared.IGeneradorNC;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor 
{
    public static void main(String[] args) 
    {
        try {
            IGeneradorNC generadorNC = new GeneradorNC();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("generadornc", generadorNC);
            System.out.println("Servidor de generación de números de control listo.");
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
