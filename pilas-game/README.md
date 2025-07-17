# Cuestionario de preguntas básicas
## Aplicación de consola en Java
### Se utilizan estructuras de datos como listas enlazadas y pilas (`ArrayDeque`) para gestionar preguntas, niveles y premios en un juego de preguntas y respuestas.

---

## Características principales

- Juego de preguntas y respuestas por niveles (tres niveles de dificultad).
- Gestión de premios mediante una pila: se otorgan premios por respuestas correctas y se revocan (pierden) por respuestas incorrectas.
- Menú interactivo para elegir nivel y comenzar el juego.
- Retroalimentación inmediata sobre respuestas correctas e incorrectas.
- Evaluación final mostrando cuántos y cuáles premios se obtuvieron.

## ¿Qué son los premios?

- **Premio:** Representa un reconocimiento por responder correctamente una pregunta.
- **Pila de Premios:** Colección de premios ganados durante el juego; se agrega un premio por cada respuesta correcta y se pierde el último premio ganado ante una respuesta incorrecta.
- **Formato:** Los premios aparecen en el formato `Premio Lx-Py`, donde `L` es el nivel (`Level`) y `P` la pregunta (`Pregunta`).  
  Ejemplo: `Premio L2-P5` significa "Premio ganado en el nivel 2, pregunta 5".

## Estructura del proyecto

```
com/
└── game/
    └── promotion/
        ├── GameConfig.java
        ├── GameManager.java
        ├── Main.java
        ├── PrizeStack.java
        ├── Question.java
        ├── QuestionLoaderNivel1.java
        ├── QuestionLoaderNivel2.java
        ├── QuestionLoaderNivel3.java
        ├── QuestionNode.java
        └── QuestionTree.java
```

## Requisitos
- Java 8 o superior

## Instrucciones de uso

1. Clona o descarga el repositorio.
2. Compila los archivos Java:
    ```bash
    javac -encoding UTF-8 com/game/promotion/*.java
    ```
3. Ejecuta la aplicación principal:
    ```bash
    java com.game.promotion.Main
    ```

## ¿Cómo jugar?
- Al iniciar, verás un menú principal.
- Elige el nivel de dificultad.
- Comienza el juego y responde las preguntas seleccionando el número de la opción correcta.
- Por cada respuesta correcta recibirás un premio (apilado); por cada incorrecta puedes perder el último premio ganado.
- Al final, se mostrarán tus resultados y una lista de los premios obtenidos, junto con su significado.