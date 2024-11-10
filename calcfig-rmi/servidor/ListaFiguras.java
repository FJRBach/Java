package servidor;

import shared.FiguraInterface;
import shared.ListaFigurasInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase implementa la interfaz `ListaFigurasInterface` y proporciona una interfaz remota para gestionar una lista de figuras.
 * Mantiene una lista de objetos `FiguraInterface` y ofrece métodos para agregar figuras, calcular el área y perímetro total,
 * y limpiar la lista.
 *
 * - **Objeto Remoto:** Extiende `UnicastRemoteObject` para habilitar la invocación de métodos remotos.
 * - **Gestión de Figuras:** Almacena y gestiona una lista de figuras.
 * - **Cálculos:** Calcula el área y perímetro total de todas las figuras.
 * - **Limpieza:** Limpia la lista de figuras.
 */

public class ListaFiguras extends UnicastRemoteObject
        implements ListaFigurasInterface 
{

    /**
     * La lista de figuras gestionada por esta clase.
     */
    private List<FiguraInterface> figuras;

    
   //Construye un nuevo objeto `ListaFiguras`.
    protected ListaFiguras() throws RemoteException 
    {
        figuras = new ArrayList<>();
    }

    /**
     * Agrega una nueva figura a la lista.
     *
     * @param figura La figura a ser agregada.
     * @throws RemoteException Si ocurre una excepción remota durante la operación.
     */
    @Override
    public void agregar(FiguraInterface figura) throws RemoteException {
        figuras.add(figura);
    }

    @Override
    public double getAreaTotal() throws RemoteException {
        double areaTotal = 0;
        for (FiguraInterface figura : figuras) {
            areaTotal += figura.calcularArea();
        }
        return areaTotal;
    }


    @Override
    public double getPerimetroTotal() throws RemoteException {
        double perimetroTotal = 0;
        for (FiguraInterface figura : figuras) {
            perimetroTotal += figura.calcularPerimetro();
        }
        return perimetroTotal;
    }
    
    @Override
    public void limpiarFiguras() throws RemoteException {
        figuras.clear();
    }
}