class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int ans=nums.length+1;
        int sum=nums[0];
        
        
        for(int j=0;j<nums.length;){
            if(sum<target){
                j++; 
                if(j<nums.length)
                    sum+= nums[j];
            }
            else{
                ans = Math.min(ans,j-i+1);
                sum-= nums[i];
                i++;
            }
            if(i>j)
                j++;
                
        }
        if(ans==nums.length+1)
            return 0;
        return ans;
    }
}