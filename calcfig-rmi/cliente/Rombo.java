package cliente;
import shared.FiguraInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Rombo extends UnicastRemoteObject 
    implements FiguraInterface 
{
    private double diagonalMayor;
    private double diagonalMenor;

    public Rombo(double diagonalMayor, double diagonalMenor) throws RemoteException 
    {
        this.diagonalMayor = diagonalMayor;
        this.diagonalMenor = diagonalMenor;
    }

    @Override
    public double calcularArea() 
    {
        return (diagonalMayor * diagonalMenor) / 2;
    }

    @Override
    public double calcularPerimetro() 
    {
        double lado = Math.sqrt((diagonalMayor / 2) * (diagonalMayor / 2) + (diagonalMenor / 2) * (diagonalMenor / 2));
        return 4 * lado;
    }
}
