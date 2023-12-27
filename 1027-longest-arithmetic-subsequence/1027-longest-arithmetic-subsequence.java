class Solution {
    public int longestArithSeqLength(int[] nums) {
        int max= Integer.MIN_VALUE;
        for(int i =0;i<nums.length-1;i++)
            max = Integer.max(max, nums[i+1]-nums[i]);
        HashMap<Integer,Integer>[] memo = new HashMap[nums.length];
        for(int i =0;i<memo.length;i++)
            memo[i] = new HashMap<>();
        
        int ans=0;
        for(int i =0;i<nums.length;i++)
        {
             
             for(int j=0;j<i;j++)
             {
                 
                 int diff = nums[i]-nums[j];
                 int temp= Math.max(memo[i].getOrDefault(diff,Integer.MIN_VALUE), memo[j].getOrDefault(diff,1)+1);
                 memo[i].put(diff,temp );
                 ans= Math.max(ans, memo[i].get(diff));
             }  
        }
//         for(HashMap temp : memo)
//             System.out.println(temp);
        
        return ans;
        
    }
}