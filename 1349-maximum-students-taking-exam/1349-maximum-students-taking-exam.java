class Solution {
    int m;
    int num;
    int[] validRows;
    int[][] dp;
    public int maxStudents(char[][] seats) {
        
        m = seats.length;
        int n = seats[0].length;
        validRows = new int[m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                validRows[i] = (validRows[i] << 1) + (seats[i][j] == '.' ? 1 : 0);
        num = 1 << n; // There are 2^n states for n columns in binary format
        dp = new int[m][num];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        int ans = 0;
        return dp(0,0);
    }
    
    public int dp(int row, int prev)
    {
        if(row==m)
            return 0;
        if(dp[row][prev]!=-1)
            return dp[row][prev];
        int max= Integer.MIN_VALUE;
        for(int i=0;i<num;i++)
        {
            if((validRows[row]&i)==i && ((i>>1)&i)==0 && ((i>>1)&prev)==0 && ((prev>>1)&i)==0 )
                max = Math.max(max , Integer.bitCount(i)+dp(row+1,i));
        }
        dp[row][prev]= max;
        return dp[row][prev];
    }
}