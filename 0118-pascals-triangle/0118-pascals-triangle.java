class Solution {
    public List<List<Integer>> generate(int x) {
        List<List<Integer>> ans = new ArrayList<>();
        int limit=1;
        for(int i=0;i<x;i++)
        {
            ans.add(new ArrayList<>());
            for(int j=0;j<limit;j++)
                ans.get(i).add(0);
            
            limit++;
        }
            
        ans.get(0).set(0,1);
        for(int i=0;i<ans.size()-1;i++)
        {
            for(int j=0;j<ans.get(i).size();j++)
            {
                int num = ans.get(i).get(j);
                ans.get(i+1).set(j, num+ ans.get(i+1).get(j) );
                ans.get(i+1).set(j+1,num+ ans.get(i+1).get(j+1));
            }    
        }
        return ans;        
    }
}