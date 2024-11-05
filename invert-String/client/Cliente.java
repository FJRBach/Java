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
            System.out.print("Ingresa una cadena para invertir: ");
            String cadena = scanner.nextLine();

            String cadenaInvertida = gestor.invertirCadena(cadena);
            System.out.println("Cadena invertida: " + cadenaInvertida);
        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
