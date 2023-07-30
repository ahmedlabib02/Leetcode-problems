class Solution {
    public int jump(int[] nums) {
        
        int ans = 0;
        for(int i=nums.length-1;i>0;)
        {
            int index= i;
            for(int j=i-1;j>=0;j--)
            {
                if(nums[j]+j>=i)
                    index = j;
            }
            i=index;
            ans++;
        }
        return ans;
    }
}