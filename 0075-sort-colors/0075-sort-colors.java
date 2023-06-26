class Solution {
    public void sortColors(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int max = nums[i];
            int maxIndex=i;
            for(int j=i;j<nums.length;j++){
                if(nums[j]<max){
                    max = nums[j];
                    maxIndex = j;
                }
                    
            }
            int temp = nums[i];
            nums[i]= max;
            nums[maxIndex]= temp;
        }
    }
}