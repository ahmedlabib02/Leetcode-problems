class Solution {
    boolean[][] memo;
    String s1;
    String s2;
    public boolean isMatch(String s, String p) {
        s1 = s;
        s2=p;
        memo = new boolean[s.length()+1][p.length()];
        return dp(0,0);
    }
    public boolean dp(int i, int j)
    {
        
        if(i==s1.length())
        {
            if(j==s2.length())
                return true;
            else  if(j!=s2.length()-1 && s2.charAt(j+1)=='*')
            {
                memo[i][j]= dp(i,j+2);
                return memo[i][j]; 
            }
            else 
                return false;
        }
        if(j==s2.length())
            return false;
        // System.out.println(i+" "+s1.charAt(i)+" "+s2.charAt(j));
        if(memo[i][j]==true)
            return true;
        
        boolean ans = false;
        if(j!=s2.length()-1&&s2.charAt(j+1)=='*')
        {
            if(s1.charAt(i)==s2.charAt(j)|| s2.charAt(j)=='.')
            {
                ans= ans|| dp(i+1,j);
            }
            ans= ans|| dp(i,j+2);
        }
        else if( s1.charAt(i)==s2.charAt(j) || s2.charAt(j)=='.')
                ans = ans|| dp(i+1,j+1);
        
        memo[i][j]= ans;
        return memo[i][j];
            
    } 
}