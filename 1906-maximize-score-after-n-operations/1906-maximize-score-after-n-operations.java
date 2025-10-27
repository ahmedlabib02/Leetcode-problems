class Solution {
    
    public int maxScore(int[] nums) {
        int[] dp = new int[1<<nums.length];
        int[][] gcd = new int[nums.length][nums.length];

        for(int i=0;i<nums.length;i++)
            for(int j=i+1;j<nums.length;j++)
                gcd[i][j] = gcd(nums[i], nums[j]);


        Set<Integer> prev = new HashSet<>();
        prev.add(dp.length-1);
        int counter =1;
        for(int round = 1;round<=nums.length/2;round++)
        {

            HashSet<Integer> curr = new HashSet<>();
            for(int state: prev)
            {
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
                        int val = dp[state]+(gcd[Math.min(i,j)][Math.max(i,j)]*counter);
                        if(val>dp[newState])
                        {
                            dp[newState] = Math.max(dp[newState],val);
                            curr.add(newState);
                        }
                    }
                }

            }
            prev= curr;
            counter++;
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