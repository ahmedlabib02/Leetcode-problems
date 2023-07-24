class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer, ArrayList<Integer>> map= new HashMap<>();
        Queue<Integer> q= new LinkedList<>();
        int[] outDegree = new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            
            outDegree[i]=graph[i].length;
            if(graph[i].length==0)
            {
                q.add(i);
            }
                 
                for(int j=0;j<graph[i].length;j++)
                {
                    if(map.get(graph[i][j])==null)
                        map.put(graph[i][j],new ArrayList<>());
                    map.get(graph[i][j]).add(i);
                    
                }
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty())
        {   
            int i = q.remove();
            for(int num: map.getOrDefault(i,new ArrayList<>()))
            {
                outDegree[num]--;
                if(outDegree[num]==0)
                    q.add(num);
            }
        }
        for(int i=0;i<outDegree.length;i++)
            if(outDegree[i]==0)
                ans.add(i);
        return ans;
    }
}