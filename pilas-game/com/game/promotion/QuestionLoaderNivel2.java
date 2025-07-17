package com.game.promotion;

import java.util.*;

public class QuestionLoaderNivel2 {
    public static List<Question> load() {
        List<Question> questions = new ArrayList<>(QuestionLoaderNivel1.load());
        questions.add(new Question(11, "¿Cómo se llama un polígono de 5 lados?", Arrays.asList(
                "Pentágono",
                "Hexágono",
                "Heptágono",
                "Octágono"
        ), 1));
        questions.add(new Question(12, "¿Cuántas horas tiene un día?", Arrays.asList(
                "12",
                "18",
                "24",
                "30"
        ), 3));
        questions.add(new Question(13, "¿Cuántos cuartos de kilo hay en un kilo?", Arrays.asList(
                "2",
                "3",
                "4",
                "5"
        ), 3));
        questions.add(new Question(14, "¿Cómo se llama quien cuenta la historia en un cuento?", Arrays.asList(
                "Protagonista",
                "Personaje",
                "Narrador",
                "Autor"
        ), 3));
        questions.add(new Question(15, "¿Cómo se llama el triángulo que tiene 3 lados iguales?", Arrays.asList(
                "Escaleno",
                "Isósceles",
                "Equilátero",
                "Obtuso"
        ), 3));
        return questions;
    }
}