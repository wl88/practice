package leetcode;

import java.util.*;

public class LC164 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0; 
        int max = 0;
        int min = Integer.MAX_VALUE;
        Set<Integer> distinct_nums= new HashSet<>();
        
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] <min) min = nums[i];
            if (nums[i] > max) max = nums[i];
            distinct_nums.add(nums[i]);
        }
        if (max == min) return 0;
        int distinct_length = distinct_nums.size();
        
        int min_gap = (max - min)/ (distinct_length-1);
        int bucket_size = (max - min)/(min_gap) + 1;
        
        int[] min_bucket = new int[bucket_size];
        int[] max_bucket = new int[bucket_size];
        Arrays.fill(min_bucket, 0);
        Arrays.fill(max_bucket, 0);
        
        for (int i = 0; i<nums.length; i++) {
            int bucket = (nums[i] - min)/min_gap;
            if (min_bucket[bucket] == 0) min_bucket[bucket] = nums[i];
            else if (nums[i] < min_bucket[bucket]) min_bucket[bucket] = nums[i];
            if (max_bucket[bucket] == 0) max_bucket[bucket] = nums[i];
            else if(nums[i] > max_bucket[bucket]) max_bucket[bucket] = nums[i];
        }
        
        int maxGap = 0;
        int small = 0;
        int big = 0;
        
        for (int i = 0; i< distinct_length-1; i++) {
            small = max_bucket[i] == 0 ? small : max_bucket[i];
            big = min_bucket[i+1] == 0 ? big : min_bucket[i+1];
            if (big - small > maxGap) maxGap = big-small;
        }
        
        return maxGap;
    }
}