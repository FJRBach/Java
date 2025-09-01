/**
 * Linked List Add Two Numbers - implementación iterativa, eficiente en tiempo y memoria.
 * 
 * Estrategia:
 * - Reutilizando lógica del ejercico de Array and Strings Count And Say.
 * - Construir la secuencia de forma iterativa, desde "1" hasta el enésimo término.
 * - Para cada iteración, escanear el término actual usando dos punteros para
 * realizar la codificación de longitud de secuencia (RLE): contar caracteres
 * idénticos consecutivos y añadir "<conteo><dígito>" al siguiente término.
 * - Usar dos instancias de StringBuilder reutilizables (curr y next) e
 * intercambiarlas entre iteraciones para minimizar las asignaciones temporales
 * y la presión del recolector de basura (GC).
 *
 * Complejidad:
 * - Tiempo: O(T), donde T es el número total de caracteres procesados en todas
 * las iteraciones. Con la restricción n <= 30, esto es pequeño en la práctica;
 * cada iteración es lineal en la longitud del término actual.
 * - Espacio (extra): O(L), donde L es la longitud de la cadena resultante
 * (salida). La memoria auxiliar extra es O(1) (unas pocas primitivas) más los
 * dos StringBuilders que se reutilizan (pequeño en promedio).
 *
 * Notas:
 * - La solución es iterativa (no recursiva) como se pide en el seguimiento.
 * - Reutilizamos búferes para reducir las asignaciones y mejorar el tiempo de
 * ejecución en los jueces en línea.
 */
public class LinkedListTwo {
    public String countAndSay(int n) {
        if (n <= 0) return "";      // invalid input guard
        if (n == 1) return "1";     // base case

        // Two reusable buffers: curr holds the current term, next is built each iteration.
        StringBuilder curr = new StringBuilder("1");
        StringBuilder next = new StringBuilder();

        // Build terms 2..n
        for (int iter = 2; iter <= n; iter++) {
            next.setLength(0); // reuse the same buffer for the next term

            int len = curr.length();
            int i = 0;
            // Scan curr with run-length encoding
            while (i < len) {
                char ch = curr.charAt(i);
                int count = 1;
                i++;
                // count repeats of ch
                while (i < len && curr.charAt(i) == ch) {
                    count++;
                    i++;
                }
                // append "<count><digit>"
                next.append(count);
                next.append(ch);
            }

            // swap curr and next (avoid copying)
            StringBuilder tmp = curr;
            curr = next;
            next = tmp;
        }

        // curr contains the nth term
        return curr.toString();
    }
}