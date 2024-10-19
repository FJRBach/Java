
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) 
    {
        try (Socket socket = new Socket("127.0.0.1", 3000)){
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            Scanner sc = new Scanner(System.in);

            System.out.println("Ingrese el valor de longitud de la cadena a generar: ");
            int cadena = sc.nextInt();

            dos.writeInt(cadena);

            /*Lectura de la cadena generada por el servidor
            * Además, se añadió un sleep de 5 segundos para poder leer la cadena generada
            */            
            String cadenaAleatoria = dis.readUTF();
            System.out.println("Cadena aleatoria generada: " + cadenaAleatoria);
            Thread.sleep(5000);

        }catch (IOException e){
            System.out.println(e.getMessage());
        } catch (InterruptedException iex) {
            System.out.println(iex.getMessage());
        }

    }

}