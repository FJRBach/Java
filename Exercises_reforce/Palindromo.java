public class Palindromo {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s == null ? null : s;

        int n = s.length();

        // Transformed string length = 2*n + 3: '^', '#', c0, '#', c1, ..., '#', '$'
        // Using sentinels '^' and '$' avoids bounds checks in expansion.
        char[] t = new char[2 * n + 3];
        t[0] = '^';
        int idx = 1;
        t[idx++] = '#';
        for (int i = 0; i < n; i++) {
            t[idx++] = s.charAt(i);
            t[idx++] = '#';
        }
        t[idx] = '$'; // last sentinel

        int m = t.length;
        int[] p = new int[m]; // p[i] = radius of palindrome centered at i in t
        int center = 0, right = 0;

        int maxLen = 0;      // length of longest palindrome in original string
        int centerIndex = 0; // center index in transformed string where max occurs

        // Manacher's main loop
        for (int i = 1; i < m - 1; i++) {
            int mirror = 2 * center - i;
            // If within right boundary, use previously computed mirror value as a lower bound
            if (i < right) {
                int available = right - i;
                int mirrored = (mirror >= 0) ? p[mirror] : 0;
                p[i] = (mirrored < available) ? mirrored : available;
            } else {
                p[i] = 0;
            }

            // Try to expand palindrome centered at i
            while (t[i + 1 + p[i]] == t[i - 1 - p[i]]) {
                p[i]++;
            }

            // If palindrome centered at i expands beyond right, update center and right
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // p[i] is the radius in transformed string; actual palindrome length in original
            // is p[i] (since transformed includes separators, number of original chars equals p[i])
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        // start index in original string
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}