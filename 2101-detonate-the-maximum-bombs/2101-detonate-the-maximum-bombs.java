class Solution {
    int[][] arr;
    HashMap<Integer, ArrayList<Integer>> map;
    public int maximumDetonation(int[][] bombs) {
        arr= bombs;
        map = new HashMap<>(); 
        for(int i=0;i<bombs.length;i++)
        {
            if(map.get(i)==null)
                map.put(i,new ArrayList<>());
            for(int j=0; j<bombs.length;j++)
            {
                if(i==j)
                    continue;
                if(isInRange(bombs[i],bombs[j]))
                    map.get(i).add(j);
            }
        }
        // System.out.print(map);
        int max=0;
        for(int i=0;i<bombs.length;i++)
        {
            boolean[] seen = new boolean[bombs.length];
            int num = dfs(i,seen);
            max= Math.max(num,max);
            
        }
        return max;
    }
    
    public boolean isInRange(int[] a, int[] b){
        int xi = a[0], yi = a[1], ri = a[2];
        int xj = b[0], yj = b[1];
        if ((long)ri * ri >= (long)(xi - xj) * (xi - xj) + (long)(yi - yj) * (yi - yj))
            return true;
        return false;
    }
    public int dfs(int i, boolean[] seen){
        seen[i]=true;
        int ans = 1;
        if(map.get(i)!=null)
        for(int bomb : map.get(i))
        {
            if(!seen[bomb])
            {
                ans+=  dfs(bomb,seen);
            }
        }
        return ans;
    }
    
    
    
    
}