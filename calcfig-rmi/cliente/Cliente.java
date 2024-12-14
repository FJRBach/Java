package cliente;
import shared.ListaFigurasInterface;
import shared.FiguraInterface;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            ListaFigurasInterface listaFiguras = (ListaFigurasInterface) Naming.lookup("rmi://localhost/ListaFiguras");
            Scanner scanner = new Scanner(System.in);
            List<FiguraInterface> figurasLocales = new ArrayList<>();
            int opcion;

            do {
                System.out.println("Menú:");
                System.out.println("1. Agregar Rombo");
                System.out.println("2. Agregar Rectángulo");
                System.out.println("3. Agregar Triángulo");
                System.out.println("4. Agregar Círculo");
                System.out.println("5. Calcular y mostrar resultados");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Diagonal mayor: ");
                        double diagonalMayor = scanner.nextDouble();
                        System.out.print("Diagonal menor: ");
                        double diagonalMenor = scanner.nextDouble();
                        Rombo rombo = new Rombo(diagonalMayor, diagonalMenor);
                        figurasLocales.add(rombo);
                        listaFiguras.agregar(rombo);
                        break;
                    case 2:
                        System.out.print("Base: ");
                        double base = scanner.nextDouble();
                        System.out.print("Altura: ");
                        double altura = scanner.nextDouble();
                        Rectangulo rectangulo = new Rectangulo(base, altura);
                        figurasLocales.add(rectangulo);
                        listaFiguras.agregar(rectangulo);
                        break;
                    case 3:
                        System.out.print("Lado A: ");
                        double ladoA = scanner.nextDouble();
                        System.out.print("Lado B: ");
                        double ladoB = scanner.nextDouble();
                        System.out.print("Lado C: ");
                        double ladoC = scanner.nextDouble();
                        Triangulo triangulo = new Triangulo(ladoA, ladoB, ladoC);
                        figurasLocales.add(triangulo);
                        listaFiguras.agregar(triangulo);
                        break;
                    case 4:
                        System.out.print("Radio: ");
                        double radio = scanner.nextDouble();
                        Circulo circulo = new Circulo(radio);
                        figurasLocales.add(circulo);
                        listaFiguras.agregar(circulo);
                        break;
                    case 5:
                        for (FiguraInterface figura : figurasLocales) {
                            System.out.println("Área: " + figura.calcularArea());
                            System.out.println("Perímetro: " + figura.calcularPerimetro());
                        }
                        double areaTotal = listaFiguras.getAreaTotal();
                        double perimetroTotal = listaFiguras.getPerimetroTotal();
                        System.out.println("\nÁrea total: " + areaTotal);
                        System.out.println("Perímetro total: " + perimetroTotal);
                        figurasLocales.clear(); // Limpiar lista local de figuras
                        listaFiguras.limpiarFiguras(); // Limpiar lista remota de figuras
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
