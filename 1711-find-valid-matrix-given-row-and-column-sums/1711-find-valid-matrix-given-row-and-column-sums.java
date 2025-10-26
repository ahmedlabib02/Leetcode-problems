class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans = new int[rowSum.length][colSum.length];
        for(int i=0;i<ans.length;i++)
        {
            for(int j=0;j<ans[i].length;j++)
            {
                int min = Math.min(colSum[j], rowSum[i]);
                colSum[j]-=min;
                rowSum[i]-=min;
                ans[i][j]= min;
            }
        }
        return ans;
    }
}