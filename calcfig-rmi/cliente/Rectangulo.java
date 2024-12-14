package cliente;

import shared.FiguraInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Rectangulo extends UnicastRemoteObject 
    implements FiguraInterface 
{
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) throws RemoteException {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}
