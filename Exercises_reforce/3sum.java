import java.util.*; 

class Solution 
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> resultado = new ArrayList<>();
	Arrays.sort(nums);
        int n = nums.length;
        if (nums == null || nums.length < 3) return resultado; 
        //ordenar para search and evitar duplicates
        
        for (int i =0; i < n - 2; i++) 
        {
            if (i > 0 && nums [i] == nums[i -1 ]) continue;
            
            if (nums[i] > 0) break;
            int left = i + 1;
            int right = n - 1; 
            
            while (left < right) 
            {
                int sum = nums[i] + nums[left] + nums [right];
                // Conditional to found tripleta válida
                if (sum == 0) 
                {
                    resultado.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Avanza left y retrocede right & salta duplicates
                    left++;
                    right--;
                    while (left < right && nums [left] == nums [left - 1]) left++;
                    while (left < right && nums [right] == nums [right + 1]) right--;
                } else if (sum < 0) 
                {
                    left++;
                } else 
                {
                    right--;
                }
            }
        }
        return resultado; 
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] a1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(s.threeSum(a1)); 
        
        int[] a2 = {0, 1, 1};
        System.out.println(s.threeSum(a2));
        
        int[] a3 = {0, 0, 0};
        System.out.println(s.threeSum(a3));
    }
}