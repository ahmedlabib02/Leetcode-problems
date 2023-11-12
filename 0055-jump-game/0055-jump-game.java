class Solution {
    
    public boolean canJump(int[] nums) {
        int max=0;
        int n = nums.length-1;
        for(int i =0;i<= Math.min(max,n);i++)
            max = Math.max(max,i+nums[i]);

        return max>=n;
    }

}
