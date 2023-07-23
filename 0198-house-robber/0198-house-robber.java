class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return dp(nums.length-1,nums);
    }
    public int dp(int i, int[] nums)
    {
        if(i==0){
            memo[0]= nums[0];
            return nums[0];
        }
        if(i==1)
        {
            memo[1] = Math.max(nums[0],nums[1]);
            return memo[1];
        }
        if(memo[i]!=-1)
            return memo[i];
        memo[i]= Math.max(dp(i-2,nums)+ nums[i], dp(i-1,nums));
        return memo[i];
        
    }
}