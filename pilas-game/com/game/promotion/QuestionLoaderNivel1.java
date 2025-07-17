package com.game.promotion;

import java.util.*;

public class QuestionLoaderNivel1 {
    public static List<Question> load() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(1, "¿Cuáles son las partes del cuerpo humano?",
                Arrays.asList("Cabeza, rodillas y dedos", "Pelo, uñas y huesos", "Tronco, extremidades y cabeza", "Manos, cuello y espalda"),
                3));
        questions.add(new Question(2, "¿Dónde lleva la tilde una palabra esdrújula?",
                Arrays.asList("En la última sílaba", "En la primera sílaba", "En la penúltima sílaba", "En la antepenúltima sílaba"),
                4));
        questions.add(new Question(3, "¿Cómo se lee la hora si la manecilla pequeña del reloj está en las 7 y la larga en las 4?",
                Arrays.asList("Las siete y veinte", "Las cuatro y siete", "Las cinco y veinte", "Las siete y cuarenta"),
                1));
        return questions;
    }
}
