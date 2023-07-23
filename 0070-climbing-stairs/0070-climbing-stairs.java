class Solution {
         HashMap<Integer,Integer> memo;
    public int climbStairs(int n) {
        memo= new HashMap<>();
        return dp(n);
    }
    public int dp(int n){
         if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(memo.get(n)!=null)
            return memo.get(n);
        memo.put(n, dp(n-1)+ dp(n-2));
        return memo.get(n); 
    }
}