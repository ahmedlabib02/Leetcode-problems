class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int num: nums)
        {
            int index = Math.abs(num)-1;
            if(nums[index]>0)
                nums[index]= nums[index]*-1;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            if(nums[i]>0)
                ans.add(i+1);
        return ans;
    }
}