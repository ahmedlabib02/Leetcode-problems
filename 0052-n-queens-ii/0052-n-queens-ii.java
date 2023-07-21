class Solution {
    int ans;
    public int totalNQueens(int n) {
        HashSet<Integer> vertical = new HashSet<>();
        HashSet<Integer> horizontal = new HashSet<>();
        HashSet<Integer> diagonal = new HashSet<>();
        HashSet<Integer> neg = new HashSet<>();
        backtrack(vertical, horizontal, diagonal,neg, 0,n);
        return ans;
        
    }
    
public void backtrack(HashSet<Integer> ver, HashSet<Integer> hor, HashSet<Integer> dia,HashSet<Integer> neg, int index,int n) 
{
    if(ver.size()==n)
        {
            ans++;
            return;
        }
    
    for(int i=index;i<n;i++)
    {
        if(!hor.contains(i))
        for(int j=0;j<n;j++)
        {
            if(!ver.contains(j) && !dia.contains(i-j) && !neg.contains(i+j))
            {
            hor.add(i);
            ver.add(j);
            dia.add(i-j);
            neg.add(i+j);    
            backtrack(ver, hor,dia, neg,i,n);
            neg.remove(i+j);    
            hor.remove(i);
            ver.remove(j);
            dia.remove(i-j);  
            }
            
        }
    }
}
        
        
    
}