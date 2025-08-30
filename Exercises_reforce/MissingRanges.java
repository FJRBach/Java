import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Solución para "Missing Ranges".
 *
 * Idea:
 * - Recorrer el arreglo ordenado `nums` una sola vez, utilizando un puntero "previo"
 * inicializado a (lower - 1).
 * - Para cada elemento `nums[i]`, tratarlo como "actual" y verificar si hay un hueco
 * entre `prev` y `curr` (es decir, `curr - prev >= 2`). Si es así, el
 * rango faltante es `[prev + 1, curr - 1]`.
 * - Después del bucle, manejar el centinela "actual = upper + 1" para capturar
 * el hueco final.
 *
 * Detalles de implementación para robustez y rendimiento:
 * - Usar una sola pasada (tiempo O(n)) y solo unas pocas variables locales primitivas
 * (espacio extra O(1)).
 * - Usar `long` para la aritmética del centinela `prev/current` para evitar el
 * desbordamiento de enteros cuando los límites están cerca de `Integer.MIN_VALUE`
 * o `Integer.MAX_VALUE`.
 * - No asignar arreglos adicionales ni realizar copias extra; solo asignar las
 * pequeñas listas de resultados requeridas para devolver los rangos faltantes.
 *
 * Complejidad:
 * - Tiempo: O(n) donde n = nums.length (escaneo único).
 * - Espacio: O(1) extra (ignorando la salida), el tamaño de la salida es
 * proporcional al número de rangos faltantes.
 */
public class MissingRanges {

    /**
     * Encuentra los rangos faltantes en [lower, upper] que no están presentes en el arreglo
     * ordenado y único `nums`.
     *
     * Devuelve una lista de rangos, donde cada rango está representado como una List<Integer> de tamaño 2: [start, end].
     */
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();

        // Usar long para evitar el desbordamiento cuando se hace +1/-1 en los límites.
        long prev = (long) lower - 1;

        // Iterar a través de nums y un centinela final (upper + 1)
        for (int i = 0; i <= nums.length; i++) {
            long curr = (i < nums.length) ? nums[i] : (long) upper + 1;

            // Si hay al menos un número faltante entre 'prev' y 'curr'.
            if (curr - prev >= 2) {
                long start = prev + 1;
                long end = curr - 1;
                // seguro para convertir a int porque las entradas y el rango son ints
                result.add(Arrays.asList((int) start, (int) end));
            }
            prev = curr;
        }

        return result;
    }
}