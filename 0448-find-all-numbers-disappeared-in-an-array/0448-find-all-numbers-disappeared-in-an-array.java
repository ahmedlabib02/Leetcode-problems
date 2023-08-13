class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            ans.add(0);
        for(int i=0;i<nums.length;i++)
        {
            ans.set(nums[i]-1,nums[i]); 
        }
        int count=1;
        for(int i=0;i<ans.size();)
            if(ans.get(i)==0)
            {
                ans.set(i,count);
                i++;
                count++;
            }   
            else
            {
                ans.remove(i);
                count++;
            }
                
        return ans;
    }
}