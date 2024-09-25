class Solution {
    int mod = 1000000007;

    public int checkRecord(int n) {
        long[][][] memo = new long[n + 1][2][3];
        
        // Base cases for n = 1
        memo[1][0][0] = 1; // "P"
        memo[1][1][0] = 1; // "A"
        memo[1][0][1] = 1; // "L"

        for (int i = 2; i < memo.length; i++) {
            for (int a = 0; a < memo[i].length; a++) {
                for (int l = 0; l < memo[i][a].length; l++) {
                    long sum = 0;

                    if (l == 0) {
                        // Sum previous states with 0, 1, and 2 lates without incrementing late
                        sum = (memo[i - 1][a][1] + memo[i - 1][a][2] + memo[i - 1][a][0]) % mod;
                        
                        // If 'A' is allowed, add states with one less 'A'
                        if (a != 0) {
                            sum = (sum + memo[i - 1][a - 1][1] + memo[i - 1][a - 1][2] + memo[i - 1][a - 1][0]) % mod;
                        }
                    } else {
                        // If there are l lates, add the state with one less late
                        sum = memo[i - 1][a][l - 1] % mod;
                    }

                    // Store the result in memo and apply mod
                    memo[i][a][l] = sum % mod;
                }
            }
        }

        long result = 0;

        // Sum all valid sequences of length n
        for (int a = 0; a < memo[n].length; a++) {
            for (int l = 0; l < memo[n][a].length; l++) {
                result = (result + memo[n][a][l]) % mod;
            }
        }

        return (int) result;
    }
}
