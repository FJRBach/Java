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
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            CalculadoraInterface calculadora = (CalculadoraInterface) registry.lookup("Calculadora");
            Scanner sc = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("====================================");
                System.out.println("Seleccione una operación:");
                System.out.println("1: Sumar");
                System.out.println("2: Restar");
                System.out.println("3: Multiplicar");
                System.out.println("4: Dividir");
                System.out.println("5: Salir");
                System.out.print("Opción: ");
                opcion = sc.nextInt();
                
                if (opcion >= 1 && opcion <= 4) {
                    System.out.print("Ingrese el primer número: ");
                    double n1 = sc.nextDouble();
                    System.out.print("Ingrese el segundo número: ");
                    double n2 = sc.nextDouble();
                    
                    double resultado = 0;
                    switch (opcion) {
                        case 1:
                            resultado = calculadora.sumar(n1, n2);
                            System.out.println("Resultado de la suma: " + resultado);
                            break;
                        case 2:
                            resultado = calculadora.restar(n1, n2);
                            System.out.println("Resultado de la resta: " + resultado);
                            break;
                        case 3:
                            resultado = calculadora.multiplicar(n1, n2);
                            System.out.println("Resultado de la multiplicación: " + resultado);
                            break;
                        case 4:
                            resultado = calculadora.dividir(n1, n2);
                            System.out.println("Resultado de la división: " + resultado);
                            break;
                    }
                } else if (opcion != 5) {
                    System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcion != 5);
            System.out.println("Saliendo del programa...");
            sc.close();
        } catch (Exception e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}