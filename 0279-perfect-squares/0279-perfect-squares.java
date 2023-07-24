class Solution {
    int[] memo;
    public static boolean check(int num) {
        int sqrt = (int) Math.sqrt(num); // Calculate the integer square root

        return sqrt * sqrt == num; // Check if the square of the integer square root is equal to the original number
    }
    public int numSquares(int n) {
        memo = new int[n+1];
        Arrays.fill(memo,-1);
        return dp(n);
    }
    public int dp(int n){
        if(n<0)
            return Integer.MAX_VALUE;
        if(check(n))
            return 1;
        if(memo[n]!=-1)
            return memo[n];
        int min= Integer.MAX_VALUE;
        for(int i=1; i*i<n;i++)
        {
            min = Math.min(1+dp(n-i*i),min);
        }
        memo[n]= min;
        return memo[n];
    }
    
    
}
