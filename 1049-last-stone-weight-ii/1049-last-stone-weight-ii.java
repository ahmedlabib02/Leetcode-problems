class Solution{
    public int lastStoneWeightII(int[] stones) {
    int totalSum = 0;
    for (int stone : stones)
        totalSum += stone;
    Integer[][] memo = new Integer[stones.length][totalSum + 1];
    return dp(stones, 0, 0, totalSum, memo);
}

public int dp(int[] stones, int index, int currentSum, int totalSum, Integer[][] memo) {
    if (index == stones.length) {
        return Math.abs(totalSum - 2 * currentSum);
    }
    
    if (memo[index][currentSum] != null) {
        return memo[index][currentSum];
    }
    
    int take = dp(stones, index + 1, currentSum + stones[index], totalSum, memo);
    int skip = dp(stones, index + 1, currentSum, totalSum, memo);
    
    memo[index][currentSum] = Math.min(take, skip);
    return memo[index][currentSum];
}

}
