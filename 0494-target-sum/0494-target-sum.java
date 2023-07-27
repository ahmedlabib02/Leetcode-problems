class Solution {
    Integer[][] memo;
    int[] arr;
    int k;
    int cons;
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int num:nums)
            cons+=num;
        memo= new Integer[nums.length][(cons*2)+1];
        k=target;
        arr= nums;
        return dp(0, 0);
    }
    
    public int dp(int i, int sum ){
        if(i==arr.length)
        {
            if(sum == k)
                return 1;
            return 0;
        }
        
        if(memo[i][sum+cons]!=null)
            return memo[i][sum+cons];
        int min = dp(i+1, sum-arr[i]);
        int add= dp(i+1, sum+arr[i]);
        memo[i][sum+cons] = add+min;
        return memo[i][sum+cons];  
    }
}