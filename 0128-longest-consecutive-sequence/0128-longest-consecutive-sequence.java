class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        for(int num: nums)  
            set.add(num);
        int ans=0;
        
        for(int i=0;i<nums.length;i++)
        {
            int num = nums[i];
            if(set.contains(num-1))
                continue;
            int count =0;
            while(set.contains(num))
            {
                set.remove(num);
                num++;
                count++;
            }
            ans= Math.max(ans,count);   
        }
        return ans;
    }
}