class Solution {
    public int singleNonDuplicate(int[] nums) {
        int i =0;
        int j = nums.length-1;
        if(nums.length==1)
            return nums[0];
        while(i<j)
        {
            System.out.println(i+" "+j);
            int mid = i+(j-i)/2;
             
            if(nums[mid]==nums[mid+1])
            {
                //odd elements 
                if((j-mid)%2==0)
                    i=mid+2;
                else
                    j=mid-1;
            }
            else if(nums[mid]==nums[mid-1])
            {
                if((j-mid)%2==0)
                    j=mid-2;
                else
                    i=mid+1;
            }
            else return nums[mid];
        }
        return nums[i];
    }
}