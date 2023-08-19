class Solution {
    public int search(int[] nums, int target) {
        int k =getK(nums);
        int n = nums.length;
        int i=k;
        int j=nums.length-1+k ;
        // System.out.println(k);
        while(i<=j)
        {
            int mid = i + (j-i)/2;
            if(nums[mid%n]==target)
                return mid%n;
            if(nums[mid%n]>target)
                j= mid-1;
            else
                i=mid+1;
        }
        return -1;
    }
    
    public int getK(int[] nums)
    {
        int i=0;
        int j = nums.length-1;
        while(i<=j)
        {
            int mid = i+(j-i)/2;
            if(nums[mid]>nums[nums.length-1])
                i=mid+1;
            else j=mid-1;   
        }
        return i;
    }

}