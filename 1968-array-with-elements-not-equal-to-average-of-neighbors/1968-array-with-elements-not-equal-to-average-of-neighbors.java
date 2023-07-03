class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        boolean flag= false;
        for(int i=1;i<nums.length-1;i++){//0 1 3 4 5
           if((double)(nums[i-1]+nums[i+1])/2==nums[i]){
               int j=i+1;
               if( ((double)(nums[i]+nums[i-1]))/2==nums[j]|| (i>1&& (double)(nums[i-2]+nums[j])/2==nums[i-1])){ 
                   j++;
               while(j<nums.length&&(double)(nums[i-1]+nums[i+1])/2==nums[j] ||(i>1&&j<nums.length&& (double)(nums[i-2]+nums[j])/2==nums[i-1]))
                    j++;
               }
               if(j<nums.length){
                  int temp = nums[i];
                  nums[i] = nums[j];
                  nums[j]= temp;
              
              } 
           }    
       }
        for(int i=nums.length-2;i>=1;i--){//0 1 3 4 5
           if((double)(nums[i-1]+nums[i+1])/2==nums[i]){
               int j=i-1;
               if( ((double)(nums[i]+nums[i+1]))/2==nums[j]|| (i<nums.length-2&& (double)(nums[i+2]+nums[j])/2==nums[i+1])){ 
                   j--;
               while(j>=0&&(double)(nums[i-1]+nums[i+1])/2==nums[j] ||(i<nums.length-2&&j>=0&& (double)(nums[i+2]+nums[j])/2==nums[i+1]))
                    j--;
               }
               if(j<nums.length){
                  int temp = nums[i];
                  nums[i] = nums[j];
                  nums[j]= temp;
              
              } 
           }    
       }
        return nums;
    }
}