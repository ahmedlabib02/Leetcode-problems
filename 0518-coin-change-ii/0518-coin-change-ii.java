class Solution {
    int[][] memo ;
    int[] arr;
    public int change(int amount, int[] coins) {
        memo = new int[amount+1][coins.length];
        for(int[] x: memo )
            Arrays.fill(x,-1);
        this.arr= coins;
        return dp(amount,0);
    }
    public int dp(int amount,int index){
        // if(amount<0)
        //     return 0;
        
        if(amount==0)
            return 1;
        if(index==arr.length)
            return 0;
        if(memo[amount][index]!=-1)
            return memo[amount][index];
        int skip = dp(amount, index+1);
        int take=0;
        if(arr[index]<=amount)
            take = dp(amount-arr[index], index);
        memo[amount][index]= skip+take;
        return memo[amount][index];
    }
}