import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(3000)) {
            System.out.println("Esperando conexiones...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Cliente conectado.");
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}

/*
* Se utiliza un handler para la construcción que inicializa socket
* Utiliza el argumento de Socket para comunicar con el cliente, hacía el socket que está inicializado
*/

class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    /* 
    * Override indicará al compilador que run (de Runnable) sobrescribe a la interfaz
    * Siendo el handler la implementación con Runnable, sobrescribiendo el método al otro
    */
    @Override
    public void run() {
        try (DataInputStream dis = new DataInputStream(socket.getInputStream());
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {

            while (true) {
                int opcion = dis.readInt();
                if (opcion == 0) {
                    System.out.println("Cliente desconectado.");
                    break;
                }
                double cantidad = dis.readDouble();
                double resultado = 0;

                switch (opcion) {
                    case 1: // Celsius a Fahrenheit
                        resultado = celsiusAFahrenheit(cantidad);
                        break;
                    case 2: // Fahrenheit a Celsius
                        resultado = fahrenheitACelsius(cantidad);
                        break;
                    default:
                        System.out.println("Opción no válida recibida.");
                        continue;
                }

                dos.writeDouble(resultado);
            }
        } catch (IOException e) {
            System.out.println("Error en la comunicación con el cliente: " + e.getMessage());
        }
    }

    private double celsiusAFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    private double fahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}
