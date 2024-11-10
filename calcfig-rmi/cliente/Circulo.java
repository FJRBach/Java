package cliente;

import shared.FiguraInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Circulo extends UnicastRemoteObject
    implements FiguraInterface 
{
    private double radio;

    public Circulo(double radio) throws RemoteException {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}

