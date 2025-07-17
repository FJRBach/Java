package com.game.promotion;

import java.util.List;

public class Question {
    private int id;
    private String prompt;
    private List<String> options;
    private int correctOption;

    public Question(int id, String prompt, List<String> options, int correctOption) {
        this.id = id;
        this.prompt = prompt;
        this.options = options;
        this.correctOption = correctOption;
    }

    public int getId() { return id; }
    public String getPrompt() { return prompt; }
    public List<String> getOptions() { return options; }
    public int getCorrectOption() { return correctOption; }
}
