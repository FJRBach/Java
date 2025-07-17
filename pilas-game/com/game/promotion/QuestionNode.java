package com.game.promotion;

public class QuestionNode {
    private Question question;
    private QuestionNode left;

    public QuestionNode(Question question) {
        this.question = question;
        this.left = null;
    }

    public Question getQuestion() {
        return question;
    }

    public QuestionNode getLeft() {
        return left;
    }

    public void setLeft(QuestionNode left) {
        this.left = left;
    }
}