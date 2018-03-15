public class Solution {
    public int superPow(int a, int[] b) {
        if (isZero(b)) return 1;
        
        a = a % 1337;
        boolean isEven = b[b.length -1] % 2 == 0 ? true : false;
        
        int result = superPow(a, div(b, 2)); //a ^ b = (a ^ (b/2))^2
        result = result * result;
        result = result % 1337;
        
        if (!isEven) {
            result = result * a;
            result = result % 1337;
        }
        
        return result;
    }
    
    public boolean isZero(int[] input) {
        for (int i : input) {
            if (i != 0) return false;
        }
        return true;
    }
    
    public int[] div(int[] input, int divisor) {
        int remainder = 0;
        for (int i = 0 ; i < input.length; i++) {
            int temp = (input[i] + remainder * 10) / divisor;
            remainder = (input[i] + remainder * 10) % divisor;
            input[i] = temp;
        }
        return input;
    }
}