class Solution {
    HashMap<Integer, List<Pair<Integer,Integer>>> graph;
    int[] distance;
    public int networkDelayTime(int[][] times, int n, int k) {
        graph= new HashMap<>();
        
        for(int[] temp : times)
        {
            int x= temp[0];
            int y= temp[1];
            int weight= temp[2];
            if(graph.get(x)==null)
                graph.put(x,new ArrayList<>());
            graph.get(x).add(new Pair(weight,y));
        }
        // System.out.print(graph);
        distance= new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        dijkstra(k);
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<distance.length; i++)
            ans= Math.max(distance[i],ans);
        if(ans==Integer.MAX_VALUE)
            return -1;
        return ans;
    }
    
    public void dijkstra(int k)
    {
        Queue<Pair<Integer,Integer>> q= new PriorityQueue<Pair<Integer,Integer>>                            (Comparator.comparing(Pair::getKey));
       q.add(new Pair(0,k));
       distance[k]= 0;
        while(!q.isEmpty())
        {
            // System.out.println(q);
            Pair<Integer,Integer> pair= q.poll();
            int weight= pair.getKey();
            int curr = pair.getValue();
            if(distance[curr]<weight)
                continue;
            if(!graph.containsKey(curr))
                continue;
            for(Pair<Integer,Integer> p: graph.get(curr))
            {
                
                int weight2 = p.getKey();
                int num  = p.getValue();
                if(distance[num]> weight2+weight)
                {
                    distance[num] = weight2+weight;
                    q.add(new Pair(distance[num],num));
                }
            }
        }
    }
}