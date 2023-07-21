class Solution {
    int ans;
    public int totalNQueens(int n) {
        HashSet<Integer> vertical = new HashSet<>();
        HashSet<Integer> diagonal = new HashSet<>();
        HashSet<Integer> neg = new HashSet<>();
        backtrack(vertical, diagonal,neg, 0,n);
        return ans;
        
    }
    
public void backtrack(HashSet<Integer> ver, HashSet<Integer> dia,HashSet<Integer> neg, int i,int n) 
{
    if(ver.size()==n)
        {
            ans++;
            return;
        }
    
        for(int j=0;j<n;j++)
        {
            if(!ver.contains(j) && !dia.contains(i-j) && !neg.contains(i+j))
            {
            
            ver.add(j);
            dia.add(i-j);
            neg.add(i+j);    
            backtrack(ver,dia, neg,i+1,n);
            neg.remove(i+j);    
            ver.remove(j);
            dia.remove(i-j);  
            }
            
        }
    
}
        
        
    
}