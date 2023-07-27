class Solution {
    int[][][] memo;
    int target;
    int[] group;
    int[] profit;
    final int MOD = 1000000007;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        this.group = group;
        this.profit = profit;
        target = minProfit;
        int sum = 0;
        for (int num : profit)
            sum += num;
        memo = new int[sum + 1][n + 1][profit.length];
        for (int[][] x : memo)
            for (int[] z : x)
                Arrays.fill(z, -1);
        return dp(0, n, 0);
    }

    public int dp(int sum, int mems, int index) {
        if (mems < 0)
            return 0;
        if (index == profit.length) {
            if (sum >= target)
                return 1;
            return 0;
        }
        if (memo[sum][mems][index] != -1)
            return memo[sum][mems][index];
        int skip = dp(sum, mems, index + 1);
        int take = dp((sum + profit[index]) % MOD, mems - group[index], index + 1);
        memo[sum][mems][index] = (skip + take) % MOD;
        return memo[sum][mems][index];
    }
}
