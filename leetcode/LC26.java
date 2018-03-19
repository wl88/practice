package leetcode;

public class LC26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int index_slow = 1;
        int index_fast = 1;
        
        int current = nums[0];
        int count = 1;
        
        while (index_fast != nums.length) {
            if (nums[index_fast] == current) {
                index_fast++;
            } else {
                current = nums[index_fast];
                nums[index_slow] = nums[index_fast];
                index_slow++;
                index_fast++;
                count++;
            }
        }
        return count;
        
    }
}