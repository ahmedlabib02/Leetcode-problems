class Solution {
    HashMap<Integer,ArrayList<Integer>> map;
    boolean[] seen;
    public int findCircleNum(int[][] isConnected) {
         map = new HashMap<>();
        for(int i=0;i<isConnected.length ;i++)
        {
            if(map.get(i)==null)
                    map.put(i,new ArrayList<>());
            for(int j=i+1;j<isConnected.length;j++)
            {

                if(map.get(j)==null)
                    map.put(j,new ArrayList<>());
                if(isConnected[i][j]==1)
                {
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
                    
            }
            
        }
        
        seen = new boolean[isConnected.length];
        int ans=0;
        for(int j=0; j<isConnected.length ;j++)
        {
            if(!seen[j])
            {
                ans++;
                seen[j]=true;
                dfs(j);
                
            }  
        }
        return ans;
    }
    public void dfs(int n){
        for(int num : map.get(n))
        {
            if(!seen[num])
            {
                seen[num]=true;
                dfs(num);
            }      
        }
          
    }
}