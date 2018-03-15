public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        
        for (int i = 0; i< nums.length -2; i++) {
            if (i >0) {
                if (nums[i] == nums[i-1]) continue;
            }
            
            
            int left = i+1;
            int right = nums.length-1;
            
            while (left < right) {
                if (left> i+1) {
                    if (nums[left] == nums[left-1]) {
                        left++;
                        continue;
                    }
                }
                if(right < nums.length-1) {
                    if (nums[right] == nums[right+1]) {
                        right--;
                        continue;
                    }
                }
                
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    ArrayList<Integer> result = new ArrayList<Integer>();
                    result.add(nums[i]);
                    result.add(nums[left]);
                    result.add(nums[right]);
                    results.add(result);
                    
                    left++;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }   
        
        return results;
        
    }
}