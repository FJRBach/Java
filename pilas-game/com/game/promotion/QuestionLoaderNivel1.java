package com.game.promotion;

import java.util.*;

public class QuestionLoaderNivel1 {
    public static List<Question> load() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(1, "¿Cuáles son las partes del cuerpo humano?", Arrays.asList(
                "Cabeza, tronco y extremidades",
                "Brazos, piernas y pies",
                "Corazón, pulmones y estómago",
                "Ojos, boca y nariz"
        ), 1));
        questions.add(new Question(2, "¿Dónde lleva la tilde una palabra esdrújula?", Arrays.asList(
                "En la última sílaba",
                "En la penúltima sílaba",
                "En la antepenúltima sílaba",
                "No lleva tilde"
        ), 3));
        questions.add(new Question(3, "¿Cómo se lee la hora si la manecilla pequeña está en las 7 y la larga en las 4?", Arrays.asList(
                "Las siete y cuarto",
                "Las siete y veinte",
                "Las seis y cuarenta",
                "Las ocho y veinte"
        ), 2));
        questions.add(new Question(4, "¿Cómo se llaman los animales que tienen un esqueleto articulado?", Arrays.asList(
                "Invertebrados",
                "Crustáceos",
                "Vertebrados",
                "Moluscos"
        ), 3));
        questions.add(new Question(5, "¿Cómo se llaman los animales que nacen de un huevo?", Arrays.asList(
                "Vivíparos",
                "Mamíferos",
                "Ovíparos",
                "Herbívoros"
        ), 3));
        questions.add(new Question(6, "¿Cuál es la sílaba tónica, la que pronunciamos con más intensidad o con menos?", Arrays.asList(
                "Con menos intensidad",
                "La del medio",
                "La que pronunciamos con más intensidad",
                "Siempre la primera"
        ), 3));
        questions.add(new Question(7, "¿Cómo se llaman los animales que nacen del vientre de la madre?", Arrays.asList(
                "Ovíparos",
                "Carnívoros",
                "Vivíparos",
                "Omnívoros"
        ), 3));
        questions.add(new Question(8, "¿Cómo se llama un polígono de 3 lados?", Arrays.asList(
                "Cuadrado",
                "Hexágono",
                "Círculo",
                "Triángulo"
        ), 4));
        questions.add(new Question(9, "¿Cómo elaboran las plantas su propio alimento?", Arrays.asList(
                "Absorbiendo minerales",
                "Por digestión",
                "A través de la fotosíntesis",
                "Por fermentación"
        ), 3));
        questions.add(new Question(10, "¿Cuántos minutos tiene una hora?", Arrays.asList(
                "100 minutos",
                "60 minutos",
                "30 minutos",
                "45 minutos"
        ), 2));
        return questions;
    }
}