package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC77_1 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< k; i++) {
            sb.append(1);
        }
        for (int i = 0; i< n-k; i++) {
            sb.append(0);
        }
        //n = 5, k = 2, max = 11000, (min = 00011)
        int max_int = Integer.parseInt(sb.toString(),2);
        
        for (int i = 0; i<=max_int; i++) {
            int ones = Integer.bitCount(i);
            if (ones == k) {
                List<Integer> perm = new ArrayList<Integer>();
                String perm_bit = Integer.toBinaryString(i);
                for (int j = 0; j < perm_bit.length(); j++) {
                    if (perm_bit.charAt(j) == '1') perm.add(n-perm_bit.length() + j + 1);
                }
                result.add(perm);
                
            }
        }
        return result;
    }
}