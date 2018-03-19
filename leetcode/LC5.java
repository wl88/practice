package leetcode;

public class LC5 {
    public String longestPalindrome(String s) {
        if (s == null) return null;
        if (s.length() == 0) return null;
        
        int max = 1;
        String maxString = s.substring(0, 1);
        
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i< s.length(); i++) isPalindrome[i][i] = true;
        for (int i = 0; i<s.length()-1; i++) {
            isPalindrome[i][i+1] = s.charAt(i) == s.charAt(i+1);
            if (isPalindrome[i][i+1]) {
                    max = 2;
                    maxString = s.substring(i, i+2);
            }
        }
        
        for (int gap = 2; gap < s.length(); gap++) {
            for (int i = 0; i<s.length() - gap; i++) {
                isPalindrome[i][i+gap] = isPalindrome[i+1][i+gap-1] && s.charAt(i) == s.charAt(i+gap);
                
                if (isPalindrome[i][i+gap] && (gap+1) > max) {
                    max = gap+1;
                    maxString = s.substring(i, i+gap+1);
                }
            }
        }
        return maxString;
    }
}