public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int diff_abs = Integer.MAX_VALUE;
        int cloest = Integer.MAX_VALUE;
        
        for (int i = 0; i< nums.length-2; i++) {
            int left = i + 1;
            int right = nums.length-1;
            
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                
                if (sum - target == 0) return sum;
                
                if (Math.abs(sum-target) < diff_abs) {
                    diff_abs = Math.abs(sum-target);
                    cloest = sum;
                    
                }
                
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return cloest;
    }
}