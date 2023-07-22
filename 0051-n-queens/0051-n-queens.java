class Solution {
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n =n;
        List<List<String>> ans = new ArrayList<>();
        HashSet<Integer> ver = new HashSet<Integer>();
        HashSet<Integer> dia = new HashSet<Integer>();
        HashSet<Integer> anti = new HashSet<Integer>();
        backtrack(new ArrayList<>(), ans,0, ver, dia, anti);
        return ans;
    }
    public void backtrack(List<String> curr, List<List<String>> ans, int hor,HashSet<Integer> ver , HashSet<Integer> dia,       HashSet<Integer> anti){
        
        if(hor==n)
        {
          ans.add(new ArrayList<>(curr));
          return;  
        }
        StringBuilder s= new StringBuilder();
        for(int i=0;i<n;i++)
            s.append('.');
        for(int i=0; i<n; i++)
        {
            if(ver.contains(i) || dia.contains(hor-i) || anti.contains(hor+i))
                continue;
            
            s.setCharAt(i,'Q');
            ver.add(i);
            dia.add(hor-i);
            anti.add(hor+i);
            curr.add(s.toString());
            backtrack(curr, ans, hor+1,ver,dia,anti);
            s.setCharAt(i,'.');
            ver.remove(i);
            dia.remove(hor-i);
            anti.remove(hor+i);
            curr.remove(curr.size()-1);  
        }
    } 
}