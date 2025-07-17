package com.game.promotion;

import java.util.*;

public class QuestionLoaderNivel2 {
    public static List<Question> load() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(4, "¿Cómo se llaman los animales que tienen un esqueleto articulado?",
                Arrays.asList("Invertebrados", "Reptiles", "Vertebrados", "Artrópodos"),
                3));
        questions.add(new Question(5, "¿Cómo se llaman los animales que nacen de un huevo?",
                Arrays.asList("Vivíparos", "Ovíparos", "Carnívoros", "Mamíferos"),
                2));
        questions.add(new Question(6, "¿Cuál es la sílaba tónica, la que pronunciamos con más intensidad o con menos?",
                Arrays.asList("Con menos intensidad", "No tiene importancia", "La que pronunciamos con más intensidad", "Es muda"),
                3));
        return questions;
    }
}
