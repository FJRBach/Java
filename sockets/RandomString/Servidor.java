import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Servidor {
    public static void main(String[] args) {
        // Catch de error con try para crear servidor en el puerto 3000
        try (ServerSocket server = new ServerSocket(3000)) {
            /* Bucle para aceptar múltiples conexiones
             * Escucha y aceptar conexión de cliente
             * Crea un nuevo hilo para manejar la conexión
            */
            do {
                Socket socket = server.accept();
                Thread hilo = new Thread(new ServidorHilo(socket));
                hilo.start();
            } while (true);
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
    }
}

// Clase que maneja cada conexión individual de cliente en un hilo separado
class ServidorHilo implements Runnable {
    // Socket para la conexión con el cliente
    Socket socket;

    // Constructor que recibe el socket de la conexión
    public ServidorHilo(Socket socket) {
        this.socket = socket;
    }

    // Método necesario de Runnable, que se ejecuta cuando inicia el hilo
    public void run() {
        
        try (
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream())
        ) {
            // Leer la longitud de la cadena del cliente
            int cadena = dis.readInt();

            // Definir caracteres permitidos en la cadena aleatoria
            String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

            // Generar y enviar cadena aleatoria al cliente
            dos.writeUTF(randomString(cadena, alfabeto));
            
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
    }

    // Método para generar una cadena aleatoria
    public String randomString(int cadena, String alfabeto) {
        // Crear objeto Random para generar números aleatorios
        Random rdm = new Random();
        
        // Usar StringBuilder para construir la cadena eficientemente
        StringBuilder randomString = new StringBuilder(cadena);

        /* Es más eficiente StringBuilder que usar String directamente 
         * porque String es inmutable (cada modificación crea un nuevo objeto)
         * alfabeto.length obtiene long de alfabeto, 
         * genera un número aleatorio entre la long de alfabeto (rdm.nextInt)
         * Obtiene el carácter con charAt
         * y con randomString.append añade el carácter a StringBuilder
         * Gracias al for, hace iteraciones hasta completar la longitud asignada; es decir 16 carácteres.
         */
       

        // Generar cadena aleatoria seleccionando caracteres del alfabeto
        for (int i = 0; i < cadena; i++) {
            randomString.append(alfabeto.charAt(rdm.nextInt(alfabeto.length())));
        }
        
        // Convertir StringBuilder a String y devolverlo
        return randomString.toString();
    }
}
