package com.game.promotion;

import java.util.*;

public class GameManager {
    private final Map<Integer, QuestionTree> levels = new HashMap<>();
    private final PrizeStack prizes = new PrizeStack();
    private final Scanner scanner = new Scanner(System.in);

    public GameManager() {
        loadQuestions();
    }

    private void loadQuestions() {
        levels.put(1, new QuestionTree(QuestionLoaderNivel1.load()));
        levels.put(2, new QuestionTree(QuestionLoaderNivel2.load()));
        levels.put(3, new QuestionTree(QuestionLoaderNivel3.load()));
    }

    public void start() {
        clearScreen(); // Limpia la pantalla al iniciar
        prizes.clear(); // Limpia la pila de premios
        System.out.printf("\nIniciando nivel %d...\n", GameConfig.currentLevel);
        QuestionTree tree = levels.get(GameConfig.currentLevel);
        if (tree == null) {
            System.out.println("Nivel no encontrado.");
            return;
        }
        int total = countQuestions(tree.getRoot());
        int correct = askQuestions(tree.getRoot());
        showResults(correct, total);
    }

    // Recorre la lista enlazada, gestiona la pila y retorna aciertos (bonus)
    private int askQuestions(QuestionNode node) {
        int correct = 0;
        while (node != null) {
            Question q = node.getQuestion();
            System.out.printf("\nPregunta %d: %s\n", q.getId(), q.getPrompt());
            for (int i = 0; i < q.getOptions().size(); i++) {
                System.out.printf(" %d) %s\n", i + 1, q.getOptions().get(i));
            }
            System.out.print("Respuesta: ");
            int ans;
            try {
                ans = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Se considera incorrecta.");
                ans = -1;
            }
            if (ans == q.getCorrectOption()) {
                String prize = String.format("Premio L%d-P%d", GameConfig.currentLevel, q.getId());
                prizes.award(prize);
                System.out.println("¡Correcto! Has ganado un premio.");
                correct++; // Puedes omitir si solo quieres pila
            } else {
                String revoked = prizes.revoke();
                if (revoked != null) {
                    System.out.printf("Incorrecto. Pierdes: %s\n", revoked);
                } else {
                    System.out.println("Incorrecto. No tenías premios para perder.");
                }
            }
            node = node.getLeft();
        }
        return correct;
    }

    private int countQuestions(QuestionNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.getLeft();
        }
        return count;
    }

  private void showResults(int correct, int total) {
    System.out.println("\n--- Resultados ---");
    System.out.printf("Respuestas correctas: %d de %d\n", correct, total);
    int premios = prizes.count();
    if (premios > 0) {
        System.out.printf("¡Felicidades! Obtuviste %d premio(s):\n", premios);
        System.out.println("Nota: L = Level (Nivel), P = Pregunta. Ejemplo: Premio L2-P5 significa premio ganado en nivel 2, pregunta 5.");
        for (String p : prizes.getAll()) {
            System.out.println(" - " + p);
        }
    } else {
        System.out.println("No obtuviste premios esta vez. ¡Sigue practicando!");
    }
}

private void clearScreen() {
    try {
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    } catch (Exception e) {
        // Si no se puede limpiar, simplemente imprime varias líneas en blanco
        for (int i = 0; i < 50; i++) System.out.println();
    }
}

}