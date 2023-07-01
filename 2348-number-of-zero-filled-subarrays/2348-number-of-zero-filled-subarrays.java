class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long sequence = 0;
        long count =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sequence++;
                count+=sequence;
            }
            else {
                sequence=0;
            }
                
        }
        return count;
    }
}