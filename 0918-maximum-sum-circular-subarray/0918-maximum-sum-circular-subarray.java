class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum=0;
        int total=0;
        int total2= 0;
        int max=Integer.MIN_VALUE;
        int ans= Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(total2<0)
                total2=nums[i];
            else
                total2+= nums[i];
            if(nums[i]+total>nums[i])
                total=nums[i];
            else
                total+=nums[i];
            sum+= nums[i];
            max= Math.max(max,total2);
            ans = Math.min(total,ans);
        }
        System.out.print(ans);
        if(sum==ans)
            return max;
        return Math.max(sum-ans,max);
    }
}