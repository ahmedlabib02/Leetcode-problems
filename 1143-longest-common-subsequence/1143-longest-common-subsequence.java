class Solution {
    int[][] memo;
    String s1;
    String s2;
    int m;
    int n;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        
        for(int[] arr: memo)
            Arrays.fill(arr,-1);
        this.s1=text1;
        this.s2=text2;
        m= text1.length();
        n= text2.length();
        return dp(0,0);
    }
    public int dp(int i,int j){
        if(i==m|| j==n)
            return 0;
        if(memo[i][j]!=-1)
            return memo[i][j];
        
        if(s1.charAt(i)==s2.charAt(j))
            memo[i][j] = 1+dp(i+1,j+1);
        else
            memo[i][j] = Math.max(dp(i,j+1) ,dp(i+1,j));

        
        return memo[i][j];
    }
}