class Solution {
    
    boolean[] seen;
    HashMap<Integer, ArrayList<Integer>> map;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        map = new HashMap<>();
        for(int[] edge : prerequisites)
        {
            int x = edge[0];
            int y= edge[1];
            if(map.get(x)==null )
                map.put(x,new ArrayList<>());
            map.get(x).add(y); 
            inDegree[y]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<inDegree.length;i++)
            if(inDegree[i]==0)
                q.add(i);
        
         for(int i=0;i<numCourses;i++)   
         {
             if(q.isEmpty())
                 return false;
             int num = q.remove();
             for(int x : map.getOrDefault(num,new ArrayList<>()))
             {
                 inDegree[x]--;
                 if(inDegree[x]==0)
                     q.add(x);
             }
             
         }
        return true;
    }
    
    
    
}