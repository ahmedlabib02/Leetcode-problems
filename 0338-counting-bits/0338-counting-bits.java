class Solution {
    int[] memo;
    public int[] countBits(int n) {
         memo= new int[n+1];
        Arrays.fill(memo,-1);
        int[] ans = new int[n+1];
        memo[0]=0;
         for(int i=n;i>=0;i-- )
         {   
             ans[i]= dp(i);
         }
        
        return ans;
        
    }
    public int dp(int n)
    {
        if(n==0)
            return 0;
        if(memo[n]!=-1)
            return memo[n];
        memo[n]= 1+ dp(n&(n-1));
        
        return memo[n];
    }
}