class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=1;i<=amount;i++)
        {
            int min =Integer.MAX_VALUE;
            for(int coin: coins)
            {
                if(i-coin>=0 && dp[i-coin]!=-1)
                min = Math.min(dp[i-coin]+1, min);
            }
            if(min!=Integer.MAX_VALUE)
            dp[i]=min;
        }
        printArray(dp);
        return dp[amount];
    }
    
    public void printArray(int[] arr)
    {
        for(int num: arr)
            System.out.print(num+" ");
    }
}