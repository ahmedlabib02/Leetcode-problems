class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        output[0]=0;
        output[1]=1;
        for(int i=0;i<nums.length;i++)
            for(int j=0;j<nums.length;j++){
                if( (nums[i]+nums[j])==target && j!=i){
                    output[0]=i;
                    output[1]=j;
                }
                

            }
        return output;
        
    }
}