class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int unique=0;
        int i =0;
        int x=0;
        int ans =0;
        for(int j=0;j<nums.length;j++)
        {
            cnt.put(nums[j], cnt.getOrDefault(nums[j],0)+1);
            if(cnt.get(nums[j])==1)
                unique++;
            if(unique==k)
            {
                while(x<j && unique==k)
                {
                    cnt.put(nums[x], cnt.get(nums[x])-1);
                    if(cnt.get(nums[x])==0)
                        unique--;
                    x++;
                }
                if(unique<k)
                {
                    x--;
                cnt.put(nums[x], cnt.get(nums[x])+1);
                if(cnt.get(nums[x])==1)
                    unique++;
                }
                
                ans+=x-i+1;
            }
            else if(unique>k) {
                i=x+1;
                while (x < j && unique >= k) {
                    cnt.put(nums[x], cnt.get(nums[x]) - 1);
                    if (cnt.get(nums[x]) == 0)
                        unique--;
                    x++;
                }
            if(unique<k)
            {
                x--;
                cnt.put(nums[x], cnt.get(nums[x]) + 1);
                if(cnt.get(nums[x])==1)
                    unique++;
            }
                
                
                
                ans += x - i + 1;
            }
        }
        return ans;
    }
}