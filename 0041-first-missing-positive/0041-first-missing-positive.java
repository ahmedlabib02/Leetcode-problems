class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] array = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0&& nums[i]<=nums.length){
                array[nums[i]-1]++;
            }
        }
        
        for(int i=0;i<array.length;i++){
            if(array[i]==0)
                return i+1;
        }
        
        
        return array.length+1;
        
        
        
    
    }
}