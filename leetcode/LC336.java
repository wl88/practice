package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        if (words.length == 0) return null;
        
        Map<String, Integer> reverseDic = new HashMap<>();
        for (int i = 0; i<words.length; i++) {
            String reversedW = new StringBuilder(words[i]).reverse().toString();
            if (!reverseDic.containsKey(reversedW)) reverseDic.put(reversedW, i);
        }
        
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i<words.length; i++) {
            String word = words[i];
            //System.out.println("\nword: " + word + " i: " + i);
            //check prefix
            for (int j = 0; j<=word.length(); j++) {
                //System.out.println("j = " + j + "\nPREFIX");
                //System.out.println("contains reverse: " + word.substring(0, j) + " => " + reverseDic.containsKey(word.substring(0, j)));
                //System.out.println("is pa: " + word.substring(j) + " => " + isPalindrome(word.substring(j)));
                if (reverseDic.containsKey(word.substring(0, j)) && isPalindrome(word.substring(j))) {
                    //System.out.println("PREFIX: contains reverse: " + word.substring(0, j) + " is pa: " + word.substring(j));
                    if (reverseDic.get(word.substring(0, j)) != i) {
                        List<Integer> pair = new ArrayList<Integer>();
                        pair.add(i);
                        pair.add(reverseDic.get(word.substring(0, j)));  
                        results.add(pair);
                    }
                }
            }
            
            //check suffix
            for (int j = 1; j<=word.length(); j++) {
                //System.out.println("j = " + j + "\nSUFFIX");
                //System.out.println("contains reverse: " + word.substring(j) + " => " + reverseDic.containsKey(word.substring(j)));
                //System.out.println("is pa: " + word.substring(0, j) + " => " + isPalindrome(word.substring(0,j)));
                if (reverseDic.containsKey(word.substring(j)) && isPalindrome(word.substring(0, j))) {
                    //System.out.println("SUFFIX: contains reverse: " + word.substring(j) + " is pa: " + word.substring(0, j));
                    if (reverseDic.get(word.substring(j)) != i) {
                        List<Integer> pair = new ArrayList<Integer>();
                        pair.add(reverseDic.get(word.substring(j)));  
                        pair.add(i);
                        results.add(pair);
                    }
                }
            }
        }
        
        return results;
    }
    
    public boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}