class Solution {
    int[] memo;
    public int mincostTickets(int[] days, int[] costs) {
       memo = new int[367];
       Arrays.fill(memo,-1); 
       boolean[] need = new boolean[367];
        for(int day : days)
            need[day]=true;
       return dp(0, need,costs) ;
    }
    public int dp(int i, boolean[] days, int[] costs)
    {
        if(i>366)
            return 0;
        if(!days[i])
            return dp(i+1, days, costs);
        if(memo[i]!=-1)
            return memo[i];

        int x = costs[1]+dp(i+7,days,costs);
        int y= costs[2]+dp(i+30,days,costs);
        int z =costs[0]+ dp(i+1,days,costs);
        memo[i]=Math.min(z, Math.min(x,y));
      return memo[i];  
    }
}