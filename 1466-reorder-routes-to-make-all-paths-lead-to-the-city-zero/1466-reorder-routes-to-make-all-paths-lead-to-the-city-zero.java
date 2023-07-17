class Solution {
    HashMap<Integer,ArrayList<Integer>> map;
    HashMap<Integer,ArrayList<Integer>> map2;
    boolean[] seen;
    int ans;
    public int minReorder(int n, int[][] connections) {
        map=new HashMap<>();
        map2= new HashMap<>();
        seen = new boolean[n];
        seen[0]= true;
        
        for(int i=0;i<connections.length;i++)
        {
            if( map2.get(connections[i][0])==null )
                map2.put(connections[i][0],new ArrayList<>());
            if(map.get(connections[i][1])==null)
                map.put(connections[i][1],new ArrayList<>());
            map.get(connections[i][1]).add(connections[i][0]);
            map2.get(connections[i][0]).add(connections[i][1]);
            
        }
        
        dfs(0);
        
        return ans;
    }
    
    public void dfs(int i){
        if(map.get(i)!=null)
        for(int num: map.get(i))
        {
            seen[num]=true;
            dfs(num);
        }
                
        
        if(map2.get(i)!=null)
        for(int num : map2.get(i))
           if(!seen[num])
            {
            seen[num]=true;   
            ans++;
            dfs(num);
            }
            
    }
    
}