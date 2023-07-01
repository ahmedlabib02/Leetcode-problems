class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=1;
        int k=1;
        while(j<nums.length){
            if(nums[j]!=nums[i]){
                 nums[i+1] = nums[j];
                 i++;
                 k++;
            }
        j++;
               
        }
        return k;
    }
}