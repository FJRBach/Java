package servidor;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Esta clase inicia el servidor RMI y registra el objeto `ListaFiguras` en el registro RMI.
 * 
 * **Responsabilidades clave:**
 * - **Inicia el Registro RMI:** Crea un registro RMI en el puerto 1099.
 * - **Registra el Objeto Remoto:** Registra el objeto `ListaFiguras` con el nombre "ListaFiguras".
 */
public class Servidor 
{
    public static void main(String[] args) 
    {
        try {
            LocateRegistry.createRegistry(1099);
            ListaFiguras listaFiguras = new ListaFiguras();
            Naming.rebind("ListaFiguras", listaFiguras);
            System.out.println("Servidor listo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}