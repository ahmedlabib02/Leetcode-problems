class Solution {
    int n;
    int[][][] memo;
    int[] prices;
    
    public int maxProfit(int k, int[] prices) {
        n = prices.length;
        memo = new int[n][2][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        
        this.prices = prices;
        return dp(0, 0, k);
    }
    
    public int dp(int i, int holding, int remain) {
        if (i == n || remain == 0) {
            return 0;
        }
        
        if (memo[i][holding][remain] != -1) {
            return memo[i][holding][remain];
        }
        
        int ans = dp(i + 1, holding, remain);
        if (holding == 1) {
            ans = Math.max(ans, prices[i] + dp(i + 1, 0, remain - 1));
        } else {
            ans = Math.max(ans, -prices[i] + dp(i + 1, 1, remain));
        }
        
        memo[i][holding][remain] = ans;
        return ans;
    }
}