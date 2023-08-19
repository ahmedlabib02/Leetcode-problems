class Solution {
    public int findPeakElement(int[] nums) {
        int i =0;
        int j = nums.length-1;
        int n = nums.length;
        while(i<j)
        {
            int mid = i+(j-i)/2;
            if(nums[mid]>nums[j]&& nums[mid]>nums[i])
            {
                if(nums[mid+1]>nums[mid])
                    i=mid+1;
                else j=mid;
            }
            else if(nums[mid]>nums[j])
                j=mid;
            else i=mid+1;
        }
        return j;
    }
}