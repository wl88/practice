public class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = nums[0];
        int current = 0;
        
        while(maxReach < nums.length-1 && current != maxReach) {
            current++;
            maxReach = current + nums[current] > maxReach ? current + nums[current] : maxReach;
        }
        
        if (maxReach >= nums.length-1) return true;
        
        return false;
    }
}