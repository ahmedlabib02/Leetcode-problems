class Solution {
    
    public int maxScore(int[] nums) {
        int[] dp = new int[1<<nums.length];
        int[][] gcd = new int[nums.length][nums.length];

        for(int i=0;i<nums.length;i++)
            for(int j=i+1;j<nums.length;j++)
                gcd[i][j] = gcd(nums[i], nums[j]);
        
            for(int state= dp.length-1; state>=0; state--)
            {
                int noBits = Integer.bitCount(state);
                if(noBits%2==1)
                    continue;
                int ops = ((Integer.bitCount(state))>>1) ;

                for(int i=0;i<nums.length;i++)
                {
                    int bit = (state>>i)&1;
                    if(bit==0)
                        continue;
                    for(int j=i+1;j<nums.length;j++)
                    {
                        int bit2= (state>>j)&1;
                        if(bit2==0)
                            continue;
                        int mask = (1<<i | 1<<j);
                        int newState = state ^ mask;
                        int val = dp[state]+(gcd[Math.min(i,j)][Math.max(i,j)]*ops);
                        if(val>dp[newState])
                        {
                            dp[newState] = Math.max(dp[newState],val);
                        }
                    }
                }

            }
        return dp[0];
    }

    private int gcd(int i, int j)
    {
        if(i<j)
            return gcd(j,i);
        if(j==0)
            return i;
        return gcd(j,i%j);
    }
}