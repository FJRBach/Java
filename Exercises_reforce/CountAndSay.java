/**
 * Count and Say - implementación iterativa, eficiente en tiempo y memoria.
 *
 * Estrategia:
 * - Construir la secuencia de forma iterativa, desde "1" hasta el enésimo término.
 * - En cada iteración, escanear el término actual usando dos punteros para realizar
 * la codificación de longitud de secuencia (RLE): contar caracteres idénticos
 * consecutivos y añadir "<conteo><dígito>" al siguiente término.
 * - Usar dos instancias reutilizables de StringBuilder (curr y next) e
 * intercambiarlas entre iteraciones para minimizar las asignaciones temporales
 * y la presión del recolector de basura (GC).
 *
 * Complejidad:
 * - Tiempo: O(T), donde T es el número total de caracteres procesados en todas
 * las iteraciones. Con la restricción n <= 30, esto es pequeño en la práctica;
 * cada iteración es lineal respecto a la longitud del término actual.
 * - Espacio (extra): O(L), donde L es la longitud de la cadena resultante
 * (salida). La memoria auxiliar extra es O(1) (pocas primitivas) más los dos
 * StringBuilder que se reutilizan (pequeño en promedio).
 *
 * Notas:
 * - La solución es iterativa (sin recursión) como se solicita en el seguimiento.
 * - Reutilizamos los búferes para reducir las asignaciones y mejorar el
 * tiempo de ejecución en los jueces en línea.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) return "";      // condición de entrada inválida
        if (n == 1) return "1";     // caso base

        // Dos búferes reutilizables: curr contiene el término actual, next se construye en cada iteración.
        StringBuilder curr = new StringBuilder("1");
        StringBuilder next = new StringBuilder();

        // Construir los términos 2..n
        for (int iter = 2; iter <= n; iter++) {
            next.setLength(0); // reutilizar el mismo búfer para el siguiente término

            int len = curr.length();
            int i = 0;
            // Escanear curr con codificación de longitud de secuencia
            while (i < len) {
                char ch = curr.charAt(i);
                int count = 1;
                i++;
                // contar las repeticiones de 'ch'
                while (i < len && curr.charAt(i) == ch) {
                    count++;
                    i++;
                }
                // añadir "<conteo><dígito>"
                next.append(count);
                next.append(ch);
            }

            // intercambiar curr y next (evitar la copia)
            StringBuilder tmp = curr;
            curr = next;
            next = tmp;
        }

        // curr contiene el enésimo término
        return curr.toString();
    }
}