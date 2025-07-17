package com.game.promotion;

import java.util.*;

public class QuestionLoaderNivel3 {
    public static List<Question> load() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(7, "¿Cómo se llaman los animales que nacen del vientre de la madre?",
                Arrays.asList("Vivíparos", "Ovíparos", "Herbívoros", "Anfibios"),
                1));
        questions.add(new Question(8, "¿Cómo se llama un polígono de 3 lados?",
                Arrays.asList("Pentágono", "Cuadrado", "Triángulo", "Hexágono"),
                3));
        questions.add(new Question(9, "¿Cómo elaboran las plantas su propio alimento?",
                Arrays.asList("A través del viento", "A través del sol directamente", "A través de la fotosíntesis", "Absorben tierra"),
                3));
        questions.add(new Question(10, "¿Cuántos minutos tiene una hora?",
                Arrays.asList("100 minutos", "90 minutos", "60 minutos", "45 minutos"),
                3));
        return questions;
    }
}
