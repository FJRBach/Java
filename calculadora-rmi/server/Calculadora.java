package server;

import shared.CalculadoraInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculadora extends UnicastRemoteObject implements CalculadoraInterface
 {

    protected Calculadora() throws RemoteException {
        super();
    }

    @Override
    public double sumar(double n1, double n2) throws RemoteException {
        return n1 + n2;
    }

    @Override
    public double restar(double n1, double n2) throws RemoteException {
        return n1 - n2;
    }

    @Override
    public double multiplicar(double n1, double n2) throws RemoteException {
        return n1 * n2;
    }

    @Override
    public double dividir(double dividiendo, double divisor) throws RemoteException {
        if (divisor == 0) {
            throw new RemoteException("No se puede dividir por cero");
        }
        return dividiendo / divisor;
    }
}
