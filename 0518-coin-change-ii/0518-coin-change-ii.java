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
        if(amount<0)
            return 0;
        if(amount==0)
            return 1;
        if(memo[amount][index]!=-1)
            return memo[amount][index];
        for(int i=index; i<arr.length;i++)
        {
            if(i==index)
            memo[amount][index]= dp(amount-arr[i],i );
            else
            memo[amount][index]+= dp(amount-arr[i],i);
        }
        return memo[amount][index];
    }
}