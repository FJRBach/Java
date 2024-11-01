import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(3000)) {
            System.out.println("Servidor iniciado. Esperando conexiones...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado.");

                // Manejo de la transferencia en un nuevo hilo
                new Thread(new FileTransferHandler(socket)).start();
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}

class FileTransferHandler implements Runnable {
    private Socket socket;

    public FileTransferHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            String fileName = "imagen.jpg"; // Nombre de archivo a enviar

            // Enviar nombre de archivo al cliente
            dos.writeUTF(fileName);

            // Abrir archivo y enviarlo por el socket
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("El archivo no existe en el servidor.");
                dos.close();
                return;
            }

            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    dos.write(buffer, 0, bytesRead);
                }
                System.out.println("Archivo enviado correctamente.");
            }
        } catch (IOException e) {
            System.out.println("Error en la transferencia de archivos: " + e.getMessage());
        }
    }
}
