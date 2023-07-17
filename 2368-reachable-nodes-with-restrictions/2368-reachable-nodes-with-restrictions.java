class Solution {
    HashSet<Integer> set ;
    HashMap<Integer, ArrayList<Integer>> map;
    boolean[] seen;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        set = new HashSet<>();
        map = new HashMap<>();    
        for(int i=0;i<restricted.length;i++)
            set.add(restricted[i]);
        
        for(int i=0;i<edges.length;i++){
            int x = edges[i][0];
            int y= edges[i][1];
            if(map.get(x)==null)
                map.put(x, new ArrayList<>());
            if(map.get(y)==null)
                map.put(y, new ArrayList<>());
            if(!set.contains(x)&& !set.contains(y))
            {
                 map.get(x).add(y);
                 map.get(y).add(x);
            }  
        }
        seen = new boolean[n];
        seen[0]= true;
        return dfs(0)+1;
    }
    public int dfs(int i){
        int ans=0;
        for(int num: map.get(i) )
        {
            if(!seen[num]){
                ans ++;
                seen[num]=true;
                ans+=dfs(num);
            }
        }
        return ans;
    }
}