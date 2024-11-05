package client;

import shared.CalculadoraInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente 
{
    public static void main(String[] args) 
    {
        try {
            // Conectar con el registro RMI
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            // Obtener la referencia a la calculadora
            CalculadoraInterface calculadora = (CalculadoraInterface) registry.lookup("Calculadora");
            Scanner sc = new Scanner(System.in);

            // Ejemplo de uso de las operaciones
            System.out.println("Introduzca dos números:");
            System.out.print("Número 1: ");
            double n1 = sc.nextDouble();
            System.out.print("Número 2: ");
            double n2 = sc.nextDouble();

            System.out.println("Resultados:");
            System.out.printf("Suma: %.2f\n", calculadora.sumar(n1, n2));
            System.out.printf("Resta: %.2f\n", calculadora.restar(n1, n2));
            System.out.printf("Multiplicación: %.2f\n", calculadora.multiplicar(n1, n2));
            System.out.printf("División: %.2f\n", calculadora.dividir(n1, n2));
            
        } catch (Exception e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
