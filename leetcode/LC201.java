package leetcode;

public class LC201 {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        
        int digits = 1;
        long multiply = 1;
        while (multiply < m) {
            multiply *= 2;
            digits++;
        }
        
        
        int result = 0;
        long current_pow = 1;
        for (int i = 0; i< digits; i++) {
            //System.out.println("index: " + i + " current_pow: " + current_pow);
            //System.out.println("first check: " + (n - m + 1) + " "  + current_pow);
            if ((n - m + 1) <= current_pow) {
                if ((n % (current_pow * 2)) / current_pow == 1) {
                    if ((m % (current_pow * 2)) / current_pow == 1) {
                        //System.out.println("need to add!");
                        result += current_pow;
                    }
                }
            }
            current_pow *= 2;
        }
        return result;
    }
}