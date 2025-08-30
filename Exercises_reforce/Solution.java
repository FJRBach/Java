import java.util.Arrays;

public class Solution {

    /**
     * O(m * n) time, O(1) extra space.
     * Uses first row and first column as markers.
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int m = matrix.length;
        int n = matrix[0].length;

        // Flags to remember if first row / first column originally contain zero
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check first row
        int[] firstRow = matrix[0];
        for (int j = 0; j < n; j++) {
            if (firstRow[j] == 0) { firstRowZero = true; break; }
        }

        // Check first column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) { firstColZero = true; break; }
        }

        // Use first row/column as markers for rows/cols to be zeroed (skip first row/col)
        for (int i = 1; i < m; i++) {
            int[] row = matrix[i]; // cache row reference
            for (int j = 1; j < n; j++) {
                if (row[j] == 0) {
                    row[0] = 0;        // mark this row
                    firstRow[j] = 0;  // mark this column (firstRow is matrix[0])
                }
            }
        }

        // Apply markers to set zeros (skip first row/col for now)
        for (int i = 1; i < m; i++) {
            int[] row = matrix[i];
            int rowMarker = row[0];
            // if rowMarker == 0 then entire row (from j=1) will be zeroed; otherwise check columns
            if (rowMarker == 0) {
                // zero entire row except column 0 (handle col 0 later if needed)
                for (int j = 1; j < n; j++) row[j] = 0;
            } else {
                // only zero positions where firstRow marker says so
                for (int j = 1; j < n; j++) {
                    if (firstRow[j] == 0) row[j] = 0;
                }
            }
        }

        // Finally zero first row and first column if needed
        if (firstRowZero) {
            // fast fill native method
            Arrays.fill(firstRow, 0);
        }

        if (firstColZero) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] mat1 = {
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };
        s.setZeroes(mat1);
        print(mat1);

        int[][] mat2 = {
            {1, 2, 3},
            {4, 0, 6},
            {7, 8, 9}
        };
        s.setZeroes(mat2);
        print(mat2);

        int[][] mat3 = {
            {1, 0},
            {1, 1}
        };
        s.setZeroes(mat3);
        print(mat3);
    }

    private static void print(int[][] a) {
        System.out.println("----");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }
}