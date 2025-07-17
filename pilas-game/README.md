# Cuestionario de preguntas básicas

## Aplicación de consola en Java

### Se utilizan estructuras de datos como listas enlazadas y pilas (`ArrayDeque`) para gestionar preguntas, niveles y premios en un juego de preguntas y respuestas.

---

## Características principales

- Juego de preguntas y respuestas por niveles.
- Gestión de premios (se otorgan o revocan según las respuestas).
- Menú interactivo para elegir nivel y comenzar el juego.
- Retroalimentación inmediata sobre respuestas correctas e incorrectas.

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
- Por cada respuesta correcta recibirás un premio; por cada incorrecta puedes perder uno.
- Al final, se mostrarán tus resultados y premios obtenidos.
