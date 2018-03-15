public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> indices = new HashMap<Character, Integer>();
        int[] results = new int[s.length()];
        results[0] = 1;
        int max = results[0];
        indices.put(s.charAt(0), 0);
        
        for (int i = 1; i<s.length(); i++) {
            int result = 0;
            char c = s.charAt(i);
            if (!indices.containsKey(c)) {
                results[i] = results[i-1] + 1;
            } else {
                results[i] = Math.min(i - indices.get(c), results[i-1]+1);
            }
            indices.put(c, i);
            if (results[i] > max) max = results[i];
        }
        return max;
    }
}