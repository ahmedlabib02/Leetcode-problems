class Solution {
    int[] coins;
    HashMap<Integer,Integer> memo;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        memo = new HashMap<>();
        if(amount==0)
            return 0;
        for(int coin : coins)
            memo.put(coin,1); 
        return dp(amount);
    }
    public int dp(int amount)
    {   
        if(amount<0)
            return -1;
        if(memo.get(amount)!=null)
            return memo.get(amount);
        
        int min = Integer.MAX_VALUE;
        boolean flag=false;
        for(int i=0;i<coins.length;i++)
        {
            int temp = 1+dp(amount-coins[i]);
            if(temp!=0)
            {
                flag=true;
                min = Math.min(temp,min);
            } 
        }
        if(!flag)
            min=-1;
        
        memo.put(amount, min);
        return memo.get(amount);
    }
    
}