class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int i=0;
        //get the with the number with the least index 
        TreeMap<Integer, Integer> sorted= new TreeMap<>();
        int ans = Integer.MIN_VALUE;
        for(int j=0;j<nums.length;j++)
        {
            
            sorted.put(nums[j], sorted.getOrDefault(nums[j],0)+1);
            while(i<j && sorted.lastKey()-sorted.firstKey()>limit)
            {
                // System.out.println(sorted);
                sorted.put(nums[i], sorted.get(nums[i])-1);
                if(sorted.get(nums[i])==0)
                    sorted.remove(nums[i]);
                i++;
            }
            // System.out.println(sorted);
            ans = Math.max(ans, j-i+1);
            
        }
        return ans;
        
    }
}