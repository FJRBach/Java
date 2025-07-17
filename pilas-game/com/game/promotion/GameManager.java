/*
 * Paquete principal para el juego de promoción/despromoción
 */
package com.game.promotion;

import java.util.*;

/**
 * Lógica principal del juego: carga, recorrido recursivo y resultado
 */
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
        prizes.clear(); // Limpia premios al iniciar
        System.out.printf("\nIniciando nivel %d...%n", GameConfig.currentLevel);
        QuestionTree tree = levels.get(GameConfig.currentLevel);
        if (tree == null) {
            System.out.println("Nivel no encontrado.");
            return;
        }
        traverse(tree.getRoot());
        showResults();
    }

    private void traverse(QuestionNode node) {
        if (node == null)
            return;
        Question q = node.getQuestion();
        System.out.printf("\nPregunta %d: %s%n", q.getId(), q.getPrompt());
        for (int i = 0; i < q.getOptions().size(); i++) {
            System.out.printf(" %d) %s%n", i + 1, q.getOptions().get(i));
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
        } else {
            String revoked = prizes.revoke();
            if (revoked != null)
                System.out.printf("Incorrecto. Pierdes: %s%n", revoked);
            else
                System.out.println("Incorrecto. No tenías premios aún.");
        }
        traverse(node.getLeft());
    }

    private void showResults() {
        System.out.println("\n--- Resultados ---");
        if (prizes.isEmpty()) {
            System.out.println("No adquiriste premios.");
        } else {
            System.out.println("Premios obtenidos:");
            prizes.getAll().forEach(p -> System.out.println(" - " + p));
        }
    }
}