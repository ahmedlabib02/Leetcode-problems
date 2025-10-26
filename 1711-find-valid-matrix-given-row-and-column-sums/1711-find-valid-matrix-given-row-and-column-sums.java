class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans = new int[rowSum.length][colSum.length];
        int i=0;
        int j=0;
        while(i<rowSum.length && j<colSum.length)
        {

            if(rowSum[i]<colSum[j])
            {
                ans[i][j]=rowSum[i];
                colSum[j]-=rowSum[i];
                rowSum[i]=0;
                i++;
            }
            else if(colSum[j]<rowSum[i])
            {
                ans[i][j]=colSum[j];
                rowSum[i]-=colSum[j];
                colSum[j]=0;
                j++;
            }
            else
            {
                ans[i][j] = colSum[j];
                rowSum[i]=colSum[j]=0;
                j++;
                i++;
            }
        }
        return ans;
    }
}