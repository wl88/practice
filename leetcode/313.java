public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        
        int[] base = new int[primes.length];
        Arrays.fill(base, 0);
        
        for (int i = 1; i<n; i++) {
            int min = Integer.MAX_VALUE;
            
            for(int j = 0; j < primes.length; j++) {
                int temp = primes[j] * ugly[base[j]];
                min = min > temp ? temp : min;
            }
            
            ugly[i] = min;
             for(int j = 0; j < primes.length; j++) {
                int temp = primes[j] * ugly[base[j]];
                if (min == temp) {
                    base[j]++;
                }
            }
        }
        
        return ugly[n-1];
    }
}