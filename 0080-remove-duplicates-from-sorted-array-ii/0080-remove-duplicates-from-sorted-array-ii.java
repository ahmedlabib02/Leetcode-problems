class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=0;
        while(j<nums.length){
            int count=0;
            int temp =nums[j];
           while(j<nums.length&&i<nums.length&&temp==nums[j] ){
              j++; 
              count++;
           }
            
        for(int x=0;x<count&&x<2;x++)
            nums[i++]= nums[j-1]; 
        
        }
        return i;
    }
}