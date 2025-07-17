package com.game.promotion;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final GameManager gameManager = new GameManager();

    public void show() {
        while (true) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1) Elegir nivel");
            System.out.println("2) Empezar juego");
            System.out.println("3) Salir");
            System.out.print("Selecciona una opción: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    chooseLevel();
                    break;
                case "2":
                    gameManager.start();
                    break;
                case "3":
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
            }
        }
    }

    private void chooseLevel() {
        System.out.print("Selecciona nivel (1-3): ");
        try {
            int level = Integer.parseInt(scanner.nextLine());
            if (level >= 1 && level <= 3) {
                GameConfig.currentLevel = level;
                System.out.println("Nivel cambiado a " + level);
            } else {
                System.out.println("Nivel inválido.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }
}
