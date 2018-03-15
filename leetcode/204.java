public class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        if (n <= 2) return 0;
        
        int currentPrime = 2;
        int total = 1;
        
        while (true) {
            //System.out.println("current prime: " + currentPrime);
            for (int i = currentPrime*2; i<n; i += currentPrime) {
                isPrime[i] = false;
            }
            
            //find next prime
            while (currentPrime < n-1) {
                currentPrime++;
                if (isPrime[currentPrime]) {
                    total++;
                    break;
                }
            }
            
            if (currentPrime >= n-1) break;
        }
        
        return total;
    }
}