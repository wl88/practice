public class Solution {
    public int characterReplacement(String s, int k) {
        int result = Math.min(s.length(), k+1);
        
        char[] chars = s.toCharArray();
        for (int i = 0; i<26; i++) {
            char letter = (char)('A' + i);
            //System.out.println("\n\ncurrent letter: " + letter);
            result = Math.max(result, calculate(chars, k, letter));
        }
        
        return result;
    }
    
    public int calculate(char[] chars, int k, char letter) {
        int start = 0;
        int end = 0;
        int used_k = 0;
        int current_result = 0;
        int max_result = 0;
        
        while (end < chars.length) {
            //System.out.println("start: " + start);
            //System.out.println("end: " + end);
            if (chars[end] == letter) {
                //System.out.println("is letter");
                current_result++;
                max_result = Math.max(current_result, max_result);
                end++;
            } else if (used_k < k) {
                //System.out.println("has k");
                current_result++;
                max_result = Math.max(current_result, max_result);
                end++;
                used_k++;
            } else {
                //System.out.println("reduce");
                if (chars[start] != letter) used_k--;
                start++;
                current_result--;
            }
            //System.out.println("max: " + max_result);
        }
        return max_result;
    }
}