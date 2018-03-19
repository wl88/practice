package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC77_2 {
    public static List<List<Integer>> results = new ArrayList<>(); 
    
    public List<List<Integer>> combine(int n, int k) {
        results.clear(); 
        ArrayList<Integer> result = new ArrayList<>();
        dfs(result, n, k, 0, 1);
        
        return results;
    }
    
    public void dfs(ArrayList<Integer> result, int n, int k, int level, int index) {
        if (level >= k) {
            results.add((ArrayList<Integer>)result.clone());
            return;
        }
        
        for (int i = index; i<n - k +2 + level; i++) {
            result.add(i);
            dfs(result, n, k, level+1, i+1);
            result.remove(new Integer(i));
        }
    }
}