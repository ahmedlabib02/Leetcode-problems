class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int num: nums)
            sum+= num;
        int prefix =0;
        
        
        for(int i=0;i<nums.length;i++)
        {
            sum -=nums[i];
            // System.out.println(prefix+" "+ sum);
            if(prefix==sum)
                return i;
            prefix += nums[i];      
        }
        
        return -1;
    }
}