package client;

import shared.GestorCadenaInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            GestorCadenaInterface gestor = (GestorCadenaInterface) registry.lookup("GestorCadena");
            
            Scanner scanner = new Scanner(System.in);
            String opcion;

            do {
                System.out.print("Ingresa una cadena para invertir (o 's' para salir): ");
                String cadena = scanner.nextLine();

                if (cadena.equalsIgnoreCase("s")) {
                    opcion = "s";
                } else {
                    String cadenaInvertida = gestor.invertirCadena(cadena);
                    System.out.println("Cadena invertida: " + cadenaInvertida);
                    opcion = "c";
                }
                
            } while (!opcion.equalsIgnoreCase("s"));

            System.out.println("Cliente cerrado.");
        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
