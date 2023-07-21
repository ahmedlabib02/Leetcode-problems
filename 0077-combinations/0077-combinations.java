class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(),ans,n,k,1);
        return ans;
    }
    public void backtrack(List<Integer> curr, List<List<Integer>> ans,int n,int k, int index)
    {
        if(curr.size()==k)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=index;i<=n;i++)
        {
            curr.add(i);
            backtrack(curr,ans,n,k,i+1);
            curr.remove(curr.size()-1);
        }
    }
        
}