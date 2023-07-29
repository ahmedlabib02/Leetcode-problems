class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[0];
        int ans=1;
        for(int num:nums)
        {
            if(num-min>k)
            {
                min= num;
                ans++;
            } 
        }
        return ans;
    }
}