package com.game.promotion;

import java.util.*;

public class QuestionLoaderNivel3 {
    public static List<Question> load() {
        List<Question> questions = new ArrayList<>(QuestionLoaderNivel2.load());
        questions.add(new Question(16, "¿Cuál es el resultado de 9 x 9?", Arrays.asList(
                "72",
                "90",
                "81",
                "99"
        ), 3));
        questions.add(new Question(17, "¿Qué número falta en la secuencia: 2, 4, 6, __, 10?", Arrays.asList(
                "7",
                "8",
                "9",
                "5"
        ), 2));
        questions.add(new Question(18, "¿Cuánto es 15 dividido entre 3?", Arrays.asList(
                "4",
                "6",
                "5",
                "3"
        ), 3));
        questions.add(new Question(19, "¿Qué número es mayor: ¾ o ⅔?", Arrays.asList(
                "⅔",
                "½",
                "¾",
                "⅓"
        ), 3));
        questions.add(new Question(20, "¿Cuánto es la mitad de 100?", Arrays.asList(
                "25",
                "75",
                "10",
                "50"
        ), 4));
        return questions;
    }
}