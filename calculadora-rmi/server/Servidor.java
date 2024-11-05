package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor
{
    public static void main(String[] args) 
    {
        try {
            // Crear una instancia de la calculadora
            Calculadora calculadora = new Calculadora();
            // Crear el registro RMI
            Registry registry = LocateRegistry.createRegistry(1099);
            // Registrar la calculadora
            registry.rebind("Calculadora", calculadora);
            System.out.println("Servidor de calculadora listo...");
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
