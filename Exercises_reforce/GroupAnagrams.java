import java.util.*;

public class GroupAnagrams {
    private static final class Key {
        int[] counts;

        Key(int[] counts) {
            this.counts = counts;
        }

        void setCounts(int[] counts) {
            this.counts = counts;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(counts); // cheap fixed-size hash (26 ints)
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Key)) return false;
            return Arrays.equals(counts, ((Key) o).counts);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // Edge cases
        if (strs == null || strs.length == 0) return new ArrayList<>();

        // Prepare results and map from Key -> group
        List<List<String>> result = new ArrayList<>();

        // Pre-size HashMap to reduce rehash cost (load factor 0.75)
        int capacity = Math.max(16, (int) (strs.length / 0.75f) + 1);
        Map<Key, List<String>> map = new HashMap<>(capacity);

        // Reusable counts array and lookup key to minimize allocations
        final int[] counts = new int[26];
        final Key lookupKey = new Key(counts); // will be reassigned to counts each iteration

        for (String s : strs) {
            // reset counts (constant 26 operations)
            Arrays.fill(counts, 0);

            // count characters (O(k) where k = s.length)
            for (int i = 0, len = s.length(); i < len; i++) {
                counts[s.charAt(i) - 'a']++;
            }

            // set lookup key's counts to current counts array
            lookupKey.setCounts(counts);

            // Try to find existing group
            List<String> group = map.get(lookupKey);
            if (group == null) {
                // Not found: clone counts into a new key (one allocation per unique group)
                int[] keyCounts = counts.clone();
                Key storedKey = new Key(keyCounts);

                // create new group and register it
                group = new ArrayList<>();
                map.put(storedKey, group);
                result.add(group);
            }

            // add string to its group (strings themselves must be kept)
            group.add(s);

        }

        return result;
    }

    public static void main(String[] args) {
        GroupAnagrams sol = new GroupAnagrams();

        String[] input1 = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> out1 = sol.groupAnagrams(input1);
        System.out.println("Input: " + Arrays.toString(input1));
        System.out.println("Output: " + out1);
        System.out.println();

        String[] input2 = {""};
        System.out.println("Input: " + Arrays.toString(input2));
        System.out.println("Output: " + sol.groupAnagrams(input2));
        System.out.println();

        String[] input3 = {"a"};
        System.out.println("Input: " + Arrays.toString(input3));
        System.out.println("Output: " + sol.groupAnagrams(input3));
        System.out.println();

        // Simple performance sanity check (not a microbenchmark)
        Random rnd = new Random(0);
        int N = 100_000; // adjust according to your machine
        String[] many = new String[N];
        for (int i = 0; i < N; i++) {
            int L = 1 + rnd.nextInt(8);
            char[] cs = new char[L];
            for (int j = 0; j < L; j++) cs[j] = (char) ('a' + rnd.nextInt(26));
            many[i] = new String(cs);
        }
        long t0 = System.nanoTime();
        List<List<String>> groups = sol.groupAnagrams(many);
        long t1 = System.nanoTime();
        System.out.printf("Processed %d random strings into %d groups in %.3f ms%n",
                N, groups.size(), (t1 - t0) / 1e6);
    }
}