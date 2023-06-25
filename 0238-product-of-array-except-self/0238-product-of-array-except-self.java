class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeros  = 0;
        int product = 1;
        for(int i=0;i<nums.length;i++){
           if(nums[i]!=0){
              product = product*nums[i]; 
               
           }
           else 
               zeros++;
           }
        
        int[] res = nums.clone();
        for(int j=0;j<res.length;j++){
            if(nums[j]==0)
                if(zeros>1)
                    res[j]=0;
                else
                    res[j]= product;
            else
                if(zeros>0)
                    res[j]=0;
                else
                res[j]= product/nums[j];
        }
        return res;
    }
}