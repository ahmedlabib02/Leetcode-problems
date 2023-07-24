class Solution {
    HashMap<Integer,Integer> memo;
    public int combinationSum4(int[] nums, int target) {
        memo = new HashMap<>();
        return dp(target,nums);
    }
    public int dp(int i, int[] nums)
    {
        if(i<0)
            return 0;
        if(i==0)
            return 1;
        if(memo.get(i)!=null)
            return memo.get(i);
        for(int num : nums)
            memo.put(i, memo.getOrDefault(i,0)+ dp(i-num, nums));
        return memo.get(i);
    }
}