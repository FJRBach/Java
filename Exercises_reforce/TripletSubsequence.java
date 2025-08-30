public class TripletSubsequence
{    
     public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                // nuevo mejor candidato para 'first' (i)
                first = num;
            } else if (num <= second) {
                // num > first pero mejor candidato para 'second' (j)
                second = num;
            } else {
                // num > second > first -> existe tripleta creciente
                return true;
            }
        }
        return false;
    }   

/* 
Método main con tests simples
*/ 
    public static void main(String[] args) {
        TripletSubsequence sol = new TripletSubsequence();

        int[] a1 = {1,2,3,4,5};
        int[] a2 = {5,4,3,2,1};
        int[] a3 = {2,1,5,0,4,6};
        int[] a4 = {2,4,-1,5}; // ejemplo con negativos

        System.out.println(sol.increasingTriplet(a1)); // true
        System.out.println(sol.increasingTriplet(a2)); // false
        System.out.println(sol.increasingTriplet(a3)); // true
        System.out.println(sol.increasingTriplet(a4)); // true
    }
}