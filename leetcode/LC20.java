package leetcode;

import java.util.Stack;

public class LC20 {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            
            if (!st.empty()) {
                if (isPair((char)st.peek(),c)) st.pop(); 
                else st.push(c);
            } else {
                st.push(c);   
            }
        }
        
        if (!st.empty()) return false;
        
        return true;
    }
    
    public boolean isPair(char a, char b) {
        if (a == '(' && b == ')') return true;
        if (a == '[' && b == ']') return true;
        if (a == '{' && b == '}') return true;
        
        return false;
    }
}