class Solution {
    int[] memo;
    HashMap<Integer,Integer> map;
    public int deleteAndEarn(int[] nums) {
        map =new HashMap<>();
        for(int num : nums)
            map.put(num,map.getOrDefault(num,0)+num);
        ArrayList<Integer> zeby = new ArrayList<>(map.keySet());
        Collections.sort(zeby);
        memo = new int[zeby.size()];
        Arrays.fill(memo,-1);
        // System.out.print(zeby);
        return dp(zeby.size()-1, zeby);
    }
    public int dp(int i, List<Integer> zeby){
        if(i==0)
        {
            memo[0]= map.get(zeby.get(0));
            return memo[0];
        }
        if(i==1)
        {
            if(zeby.get(0)==zeby.get(1)-1)
            memo[1] = Math.max(map.get(zeby.get(0)), map.get(zeby.get(1)));
            else 
                memo[1]= map.get(zeby.get(0)) + map.get(zeby.get(1) );
            return memo[1];
        }
        if(memo[i]!=-1)
            return memo[i];
        
        if(zeby.get(i-1)==zeby.get(i)-1)
        {
            memo[i] = Math.max(dp(i-2,zeby)+map.get(zeby.get(i)) ,  dp(i-1, zeby) );
        }
        else 
        {
            memo[i] = map.get(zeby.get(i)) + dp(i-1,zeby) ;
        }
        return memo[i];     
    }
}