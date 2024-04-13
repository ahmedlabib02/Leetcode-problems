class Solution {
    int[][] memo;
    int[] nums1;
    int[] nums2;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        memo = new int[nums1.length][nums2.length];
        for(int[] arr : memo)
            Arrays.fill(arr,-1);
        return dp(0,0);
    }
    public int dp(int i, int j){
        if(i>nums1.length-1|| j>nums2.length-1)
            return 0;
        if(memo[i][j]!=-1)
            return memo[i][j];
        if(nums1[i]==nums2[j])
        {
            memo[i][j] = 1+dp(i+1,j+1);
        }
        else 
        {
            memo[i][j] = Math.max(dp(i+1,j), dp(i,j+1));
        }
        
        return memo[i][j];
            
    }
    
}