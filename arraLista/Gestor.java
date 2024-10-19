import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gestor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Tarea> listaTareas = new ArrayList<>();
        int opcion = 0;

        do {
            System.out.println("Menú de Gestión de Tareas");
            System.out.println("1. Agregar tarea al final");
            System.out.println("2. Agregar tarea al inicio");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Mostrar tareas");
            System.out.println("5. Buscar tarea por descripción");
            System.out.println("6. Modificar tarea");
            System.out.println("7. Buscar tarea por posición o número de tarea");
            System.out.println("10. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.next(); // Limpiar el buffer
                continue; // Volver al inicio del bucle
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa la descripción de la tarea: ");
                    String descripcion = scanner.nextLine();
                    listaTareas.add(new Tarea(descripcion));
                    System.out.println("Tarea agregada al final correctamente.");
                    break;
                case 2:
                    System.out.print("Ingresa la descripción de la tarea: ");
                    String descripcionInicio = scanner.nextLine();
                    listaTareas.add(0, new Tarea(descripcionInicio));
                    System.out.println("Tarea agregada al inicio correctamente.");
                    break;
                case 3:
                    System.out.print("Ingresa el índice de la tarea a eliminar: ");
                    try {
                        int indiceEliminar = scanner.nextInt();
                        if (indiceEliminar >= 0 && indiceEliminar < listaTareas.size()) {
                            listaTareas.remove(indiceEliminar);
                            System.out.println("Tarea eliminada correctamente.");
                        } else {
                            System.out.println("Índice no válido.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, ingresa un número válido.");
                        scanner.next(); // Limpiar el buffer
                    }
                    break;
                case 4:
                    System.out.println("Lista de Tareas:");
                    for (int i = 0; i < listaTareas.size(); i++) {
                        System.out.println(i + ". " + listaTareas.get(i));
                    }
                    break;
                case 5:
                    System.out.print("Ingresa la descripción de la tarea a buscar: ");
                    String tareaBuscar = scanner.nextLine();
                    boolean encontrada = false;
                    for (Tarea tarea : listaTareas) {
                        if (tarea.toString().equalsIgnoreCase(tareaBuscar)) {
                            encontrada = true;
                            break;
                        }
                    }
                    System.out.println(encontrada ? "Tarea encontrada." : "Tarea no encontrada.");
                    break;
                case 6:
                    System.out.print("Ingresa el índice de la tarea a modificar: ");
                    try {
                        int indiceModificar = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer
                        if (indiceModificar >= 0 && indiceModificar < listaTareas.size()) {
                            System.out.print("Ingresa la nueva descripción de la tarea: ");
                            String nuevaDescripcion = scanner.nextLine();
                            listaTareas.set(indiceModificar, new Tarea(nuevaDescripcion));
                            System.out.println("Tarea modificada correctamente.");
                        } else {
                            System.out.println("Índice no válido.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, ingresa un número válido.");
                        scanner.next(); // Limpiar el buffer
                    }
                    break;
                case 7:
                    System.out.print("Ingresa el índice de la tarea a buscar: ");
                    try {
                        int indiceBuscar = scanner.nextInt();
                        if (indiceBuscar >= 0 && indiceBuscar < listaTareas.size()) {
                            System.out.println("Tarea en la posición " + indiceBuscar + ": " + listaTareas.get(indiceBuscar));
                        } else {
                            System.out.println("Índice no válido.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, ingresa un número válido.");
                        scanner.next(); // Limpiar el buffer
                    }
                    break;
                case 8:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 10);
    }
}
