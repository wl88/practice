package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC131 {
    private boolean[][] isPalindrome;
    List<List<String>> results = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        isPalindrome = new boolean[s.length()+1][s.length()+1];
        
        for (int i = 0; i<=s.length(); i++) Arrays.fill(isPalindrome[i], false);
        
        for (int i = 0; i<s.length(); i++) {
            for (int j = i+1; j<=s.length(); j++) {
                if (s.substring(i, j).equals(new StringBuilder(s.substring(i, j)).reverse().toString())) isPalindrome[i][j] = true;
            }
        }
        
        //for (int i = 0; i<=s.length(); i++) System.out.println(Arrays.toString(isPalindrome[i]));
        List<String> current = new ArrayList<String>();
        partitionHelper(current, s, 0);
        
        return results;
    }
    
    public void partitionHelper(List<String> current, String s, int beginIndex) {
        //System.out.println("current: " + current + " beginIndex: " + beginIndex);
        if (beginIndex == s.length()) {
            results.add(new ArrayList<String>(current));
            return;
        }
        
        for (int endIndex = beginIndex+1; endIndex<=s.length(); endIndex++) {
            if (isPalindrome[beginIndex][endIndex]) {
              String partitionString = s.substring(beginIndex, endIndex);
              current.add(partitionString);
              partitionHelper(current, s, endIndex);
              current.remove(current.size()-1);
            }
        }
    }
}