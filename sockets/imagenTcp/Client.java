import java.io.*;
import java.net.Socket;

public class Client{
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Dirección del servidor
        int port = 3000; // Puerto del servidor

        try (Socket socket = new Socket(serverAddress, port);
             DataInputStream dis = new DataInputStream(socket.getInputStream())) {

            // Recibir el nombre del archivo desde el servidor
            String fileName = dis.readUTF();
            File file = new File(fileName);

            // Verificar si ya existe el archivo, y cambiar el nombre si es necesario
            int counter = 1;
            while (file.exists()) {
                String newFileName = fileName.substring(0, fileName.lastIndexOf('.')) +
                                     "(" + counter + ")" +
                                     fileName.substring(fileName.lastIndexOf('.'));
                file = new File(newFileName);
                counter++;
            }

            // Crear el archivo en el cliente
            try (FileOutputStream fos = new FileOutputStream(file)) {
                byte[] buffer = new byte[4096];
                int bytesRead;

                // Recibir datos del archivo del servidor y escribirlos en el archivo local
                while ((bytesRead = dis.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }

                System.out.println("Archivo recibido y guardado como: " + file.getName());
            }
        } catch (IOException e) {
            System.out.println("Error en la conexión o transferencia: " + e.getMessage());
        }
    }
}
