class Solution {
    public int[] searchRange(int[] nums, int target) {

        int i =0;
        int j = nums.length-1;
        while(i<j)
        {
            int mid = i+(j-i)/2;
            if(nums[mid]==target && (mid==nums.length-1||nums[mid+1]!=target))
            {
                i = mid;
                break;
            }
            if(nums[mid]==target )
                i=mid+1;
            else if(nums[mid]>target)
                j=mid-1;
            else
                i=mid+1;
        }
        int end = i;
        i=0;
        j=nums.length-1;
        while(i<j)
        {
            int mid = i+(j-i)/2;
            if(nums[mid]==target && (mid==0||nums[mid-1]!=target ))
            {
                j=mid;
                break;
            }
            if(nums[mid]==target)
                j=mid-1;
            else if(nums[mid]>target)
                j=mid-1;
            else
                i=mid+1;
        }
        int start = j;
        System.out.print(i+" "+j);
        if(i>=nums.length||j<0||nums.length==0||nums[start]!=target || nums[end]!=target)
            return new int[]{-1,-1};
        return new int[]{start,end};
    }
}