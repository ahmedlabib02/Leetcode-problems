class Solution {
    int[][] memo; 
    int[] arr;
    public int maxProduct(int[] nums) {
        int[] min = new int[nums.length];
        int[] max= new int[nums.length];
        min[0]= nums[0];
        max[0]=nums[0];
        int ans= Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++)
        {
            min[i]= Math.min(Math.min(min[i-1]*nums[i], max[i-1]*nums[i]), nums[i]);
            max[i]= Math.max(Math.max(max[i-1]*nums[i], min[i-1]*nums[i]),  nums[i]);
            
        }
        for(int num: max)
            ans= Math.max(num, ans);
        return ans;
        
    }
    
}