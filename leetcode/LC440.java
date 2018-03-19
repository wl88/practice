package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC440 {
    public int findKthNumber(int n, int k) {
        //System.out.println("\n");
        int max_index = Integer.toString(n).length();
        
        Map<Integer, Integer> count_library = new HashMap<>();
        count_library.put(0,1);
        for (int i = 1; i< max_index; i++) {
            count_library.put(i, 1 + 10 * count_library.get(i-1));
        }
        
        long current = 1;
        k = k-1;
        
        while (k > 0) {
            long steps = calculateSteps(n, current, current+1);
            if (steps <= k ) {
                current += 1;
                k -= steps;
            } else {
                current *= 10;
                k -= 1;
            }
        }
        
        return (int) current;
    }
    
    public long calculateSteps(int n, long a, long b) {
        long result = 0;
        
        while (a <= n) {
            result += Math.min(n+1, b) - a;
            a *= 10;
            b *= 10;
        }
        
        return result;
        
    }
}