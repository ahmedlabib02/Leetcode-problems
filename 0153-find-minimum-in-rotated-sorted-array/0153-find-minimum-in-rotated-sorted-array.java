class Solution {
    public int findMin(int[] nums) {
        int i =0;
        int j=nums.length-1;
        int n= nums.length-1;
        while(i<j)
        {
            int mid = i+(j-i)/2;
            if(nums[mid]>nums[n])
                i=mid+1;
            else
                j=mid;
        }
        return nums[i];
    }
}