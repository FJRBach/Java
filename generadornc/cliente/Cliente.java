package cliente;

import shared.IGeneradorNC;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente 
{
    public static void main(String[] args) 
    {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            IGeneradorNC generadorNC = (IGeneradorNC) registry.lookup("generadornc");
            Scanner sc = new Scanner(System.in);
            String continuar;

            do {
                System.out.print("Ingrese el año de ingreso (ejemplo: 2024): ");
                int anio = sc.nextInt();
                System.out.print("Ingrese el número de tecnológico: ");
                int tec = sc.nextInt();

                String numeroControl = generadorNC.generarNC(anio, tec);
                System.out.println("Número de control generado: " + numeroControl);

                // Pregunta al usuario si desea continuar
                System.out.print("¿Desea generar otro número de control? (S/s para salir, cualquier otra tecla para continuar): ");
                continuar = sc.next();
                
            } while (!continuar.equalsIgnoreCase("S")); // Continúa hasta que el usuario ingrese 'S' o 's'

            sc.close();
            System.out.println("Salida del programa. Gracias por usar el generador de números de control.");
        } catch (Exception e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}