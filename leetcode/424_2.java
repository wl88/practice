public class Solution {
    public int characterReplacement(String s, int k) {
        int[] char_count = new int[26];
        Arrays.fill(char_count, 0);
        
        int start = 0;
        int result = 0;
        
        for (int end = 0; end < s.length(); end++) {
            char_count[s.charAt(end) - 'A']++;
            result = Math.max(result, char_count[s.charAt(end) - 'A']);
            
            if (result + k < end - start + 1) {
                char_count[s.charAt(start) - 'A']--;
                start++;
            }
        }
        
        return Math.min(s.length(), result + k);
    }
}