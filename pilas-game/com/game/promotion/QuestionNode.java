package com.game.promotion;

public class QuestionNode {
    private Question question;
    private QuestionNode left;

    // Constructor
    public QuestionNode(Question question) {
        this.question = question;
        this.left = null;
    }

    // Getters
    public Question getQuestion() {
        return question;
    }

    public QuestionNode getLeft() {
        return left;
    }

    // Setter
    public void setLeft(QuestionNode left) {
        this.left = left;
    }
}