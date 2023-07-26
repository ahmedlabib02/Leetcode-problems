class Solution {
    int[][][]memo;
    int k;
    int[] arr;
    public int maxProfit(int k, int[] prices) {
        memo= new int[prices.length][k][2];
        for(int[][] x: memo)
            for(int []arr :x)
            Arrays.fill(arr,-1);
        this.k=k;
        arr=prices;
        return dp(0,0,0);
    }
    public int dp(int i, int taken,int round )
    {
        if(round==k|| i==arr.length )
            return 0;
        
        if(memo[i][round][taken]!=-1)
            return memo[i][round][taken];
        int skip = dp(i+1,taken,round);
        if(taken==0)
        {
            int buy = -arr[i]+dp(i+1, 1, round);
            memo[i][round][taken]= Math.max(skip,buy);
        }
            
        else 
        {
            int sell = arr[i]+dp(i+1,0,round+1);
            memo[i][round][taken]= Math.max(skip,sell);
        }
        return memo[i][round][taken];
    }
}