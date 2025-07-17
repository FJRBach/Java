package com.game.promotion;

import java.util.*;

public class GameManager {
    private final Map<Integer, QuestionTree> levels = new HashMap<>();
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

    // Recorre la lista enlazada y pide respuestas
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
                correct++;
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
    String calif = "";
    if (total == 10) {
        if (correct >= 7 && correct < 9) {
            calif = "¡Has aprobado la asignatura!";
        } else if (correct >= 9 && correct <= 10) {
            calif = "¡Has aprobado y obtienes 5 puntos decimales extra para el siguiente tema!";
        } else {
            calif = "No has aprobado. Intenta otra vez.";
        }
    } else if (total == 15) {
        if (correct >= 11 && correct <= 13) {
            calif = "¡Has aprobado la asignatura!";
        } else if (correct >= 14 && correct <= 15) {
            calif = "¡Has aprobado y obtienes 5 puntos decimales extra para el siguiente tema!";
        } else {
            calif = "No has aprobado. Intenta otra vez.";
        }
    } else if (total == 20) {
        if (correct >= 15 && correct <= 17) {
            calif = "¡Has aprobado la asignatura!";
        } else if (correct >= 18 && correct <= 20) {
            calif = "¡Has aprobado y obtienes 5 puntos decimales extra para el siguiente tema!";
        } else {
            calif = "No has aprobado. Intenta otra vez.";
        }
    }
    System.out.println(calif);
}
}