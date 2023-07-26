class Solution {
    int[][] memo;
    String s1;
    String s2;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for(int[] arr: memo)
            Arrays.fill(arr,-1);
        this.s1=text1;
        this.s2=text2;
        return dp(0,0);
    }
    public int dp(int i,int j){
        if(i==s1.length()|| j==s2.length())
            return 0;
        if(memo[i][j]!=-1)
            return memo[i][j];
        int max = 0;
        if(s1.charAt(i)==s2.charAt(j))
            max = Math.max(1+dp(i+1,j+1), max);
        else
        {
            max = Math.max(dp(i,j+1) ,max);
            max = Math.max(dp(i+1,j) ,max);
        }
        memo[i][j]= max;
        return memo[i][j];
    }
}