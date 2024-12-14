import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 3000);
             DataInputStream dis = new DataInputStream(socket.getInputStream());
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Conectado al servidor.");
            while (true) {
                System.out.println("Seleccionar opción de conversión:");
                System.out.println("1. Celsius a Fahrenheit.");
                System.out.println("2. Fahrenheit a Celsius.");
                System.out.println("0. Salir");
                System.out.print("Introducir opción [0-2]: ");
                int opcion = scanner.nextInt();

                dos.writeInt(opcion);
                if (opcion == 0) {
                    System.out.println("Saliendo del programa.");
                    break;
                }

                System.out.print("Introducir cantidad a convertir: ");
                double cantidad = scanner.nextDouble();

                dos.writeDouble(cantidad);
                double resultado = dis.readDouble();
                System.out.println("Resultado de la conversión: " + resultado);
            }
        } catch (IOException e) {
            System.out.println("Error en la comunicación con el servidor: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
