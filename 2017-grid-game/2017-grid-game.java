class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[1].length;
        long down = 0;
        long right = 0;
        for(int i=0;i<n-1;i++)
            down+= grid[1][i];   
        long ans= Long.MAX_VALUE;
        for(int i=n-1;i>0;i--)
        {
            long temp = Math.max(down, right);
            ans =Math.min(temp, ans);
            right+= grid[0][i];
            down -= grid[1][i-1];
        }
        ans = Math.min(Math.max(down,right),ans);
        return ans;
        
    }
}