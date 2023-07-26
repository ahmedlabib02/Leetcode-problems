class Solution {
    int[][] memo;
    int[] arr;
    int x;
    public int maxProfit(int[] prices, int fee) {
        x=fee;
        arr= prices;
        memo = new int[2][prices.length];
        for(int[] x: memo)
            Arrays.fill(x,-1);
        return dp(0, 0);
    }
    public int dp(int i, int taken)
    {
        if(i==arr.length)
            return 0;
        if(memo[taken][i]!=-1)
            return memo[taken][i];
        int skip = dp(i+1, taken);
        if(taken==0)//buying
        {
            memo[taken][i]= Math.max(skip,-arr[i]+dp(i+1,1));
        }
        else //selling
        {
            memo[taken][i]= Math.max(skip,arr[i]-x+dp(i+1,0));
        }
        return memo[taken][i];
    }
}