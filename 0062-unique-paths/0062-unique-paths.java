class Solution {
    int[][] memo;
    int m;
    int n;
    public int uniquePaths(int m, int n) {
        memo= new int[m][n];
        // for(int[] x: memo)
        //     Arrays.fill(x,-1);
        memo[0][0]=1;
        for(int i=0;i<memo.length;i++)
        {
            for(int j=0;j<memo[i].length;j++)
            {
                if(i!=memo.length-1)
                    memo[i+1][j]+=memo[i][j];
                if(j!=memo[i].length-1)
                    memo[i][j+1]+=memo[i][j];
            }
        }
        // for(int i=0;i<memo.length;i++)
        // {
        //     for(int j=0;j<memo[i].length;j++)
        //         System.out.print(memo[i][j]+" ");
        //     System.out.println();
        // }
            
        return memo[m-1][n-1];
    }
    public int dp(int i,int j)
    {
        if(i==m-1&&j==n-1)
            return 1;
        if(memo[i][j]!=-1)
            return memo[i][j];
        int down=0;
        if(i!=m-1)
           down = dp(i+1,j);
        int right =0;
        if(j!=n-1)
            right= dp(i,j+1);
        memo[i][j]= down+right;
        return memo[i][j];
    }
}