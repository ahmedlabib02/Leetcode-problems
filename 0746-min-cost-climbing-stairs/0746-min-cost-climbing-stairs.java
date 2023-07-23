class Solution {
    int[] cost;
    HashMap<Integer,Integer> map;
    public int minCostClimbingStairs(int[] cost) {
        map = new HashMap<>();
        this.cost = cost;
        return dp(cost.length);
    }
    public int dp(int i){
        if(i==0 || i==1) 
            return 0;
        if(map.get(i)!=null)
            return map.get(i);
        map.put(i, Math.min( dp(i-1)+ cost[i-1], dp(i-2)+ cost[i-2]  ));
        return map.get(i);
    }
}