class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1)
            return nums;
        int i=0;
        int j=0;
        int maxIndex = 0;
        int[] res= new int[nums.length-k+1];
        
        
        while(j<k){
            if(nums[maxIndex]<=nums[j])
                maxIndex = j; 
            j++;
        }
            
        
        int second;
        if(maxIndex==k-1)
            second=maxIndex-1;
        else 
            second = maxIndex+1;
        
        for(int x=0;x<k;x++)
            if(nums[x]>nums[second]&& x!=maxIndex)
                second=x;  
            
        j--;
        int p = 0;
        while(j<nums.length){
            System.out.println(i+" "+j);
            res[p]= nums[maxIndex];
            if(j!=nums.length-1 && nums[j+1]>=nums[maxIndex])
                maxIndex=j+1;
            if(i==maxIndex && j!=nums.length-1 &&j==i+k-1)
            {
                maxIndex=i+1;
                for(int x=i+1;x<=j+1;x++)
                    if(nums[x]>=nums[maxIndex]){
                        maxIndex=x;
                    }
                        
                i=maxIndex;  
            }  
            
            if(j!=i+k-1)
            {
                j++;
            }
            else
            {
               i++;
               j++;  
            }
            p++;
        }
        
     return res;   
    }
    
}