package cliente;

import shared.FiguraInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Esta clase implementa la interfaz `FiguraInterface` para representar un triángulo.
 * Calcula el área y perímetro del triángulo utilizando la fórmula de Herón.
 * 
 * - **Triángulo:** Almacena los lados del triángulo.
 * - **Cálculo de Área:** Calcula el área del triángulo utilizando la fórmula de Herón.
 * - **Cálculo de Perímetro:** Calcula el perímetro del triángulo sumando sus lados.
 */

public class Triangulo extends UnicastRemoteObject
    implements FiguraInterface 
{
    private double ladoA;
    private double ladoB;
    private double ladoC;

    public Triangulo(double ladoA, double ladoB, double ladoC) throws RemoteException 
    {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    @Override
    public double calcularArea() 
    {
        double semiPerimetro = (ladoA + ladoB + ladoC) / 2;
        return Math.sqrt(semiPerimetro * (semiPerimetro - ladoA) * (semiPerimetro - ladoB) * (semiPerimetro - ladoC));
    }

    @Override
    public double calcularPerimetro() 
    {
        return ladoA + ladoB + ladoC;
    }
}
