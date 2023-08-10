class Solution {
    int mod = 1000000007;

    public int numPrimeArrangements(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++)
            isPrime[i] = true;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int primes = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes++;
            }
        }
        
        long primeArrangements = factorial(primes);
        long nonPrimeArrangements = factorial(n-primes);

        long result = (primeArrangements * nonPrimeArrangements) % mod;
        
        return (int) result;
    }

    public long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = (result * i) % mod;
        }
        return result;
    }
}
