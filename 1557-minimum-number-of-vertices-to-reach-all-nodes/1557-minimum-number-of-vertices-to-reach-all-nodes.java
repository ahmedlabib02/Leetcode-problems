class Solution {
    HashMap<Integer,ArrayList<Integer>> map; 
    boolean[] seen;
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        map = new HashMap<>();
        for(int i=0;i<edges.size();i++)
        {
            int x = edges.get(i).get(1);
            int y = edges.get(i).get(0);
            if(map.get(x)==null)
                map.put(x,new ArrayList<>());
            map.get(x).add(y);
        }
        ArrayList<Integer> ans= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(map.get(i)==null)
                ans.add(i);
        }
        return ans;
    }
//     public void dfs(int i){
//         if(map.get(i)!=null)
//         {
//             for(int num: map.get(i))
//             {
//                 if(!seen[num])
//                 {
//                     seen[num]=true;
//                     ans.add(num);
//                     dfs(num);
//                 }
//             }
//         }
        
//     }
}