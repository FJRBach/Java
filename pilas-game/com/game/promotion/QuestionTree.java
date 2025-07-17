package com.game.promotion;

import java.util.List;

public class QuestionTree {
    private QuestionNode root;

    // Crea una lista enlazada lineal de preguntas
    public QuestionTree(List<Question> questions) {
        if (questions == null || questions.isEmpty()) {
            this.root = null;
            return;
        }
        QuestionNode head = new QuestionNode(questions.get(0));
        QuestionNode current = head;
        for (int i = 1; i < questions.size(); i++) {
            QuestionNode next = new QuestionNode(questions.get(i));
            current.setLeft(next);
            current = next;
        }
        this.root = head;
    }

    public QuestionNode getRoot() {
        return root;
    }
}