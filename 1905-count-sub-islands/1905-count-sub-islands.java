class Solution {
    int[][] temp;
    int[][] arr;
    boolean flag=true;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ans=0;
        temp = grid1;
        arr = grid2;
        for(int i=0;i<grid2.length;i++)
            for(int j=0;j<grid2[i].length;j++)
            {
                if(grid2[i][j]!=0)
                {
                    flag=true;
                    dfs(i,j);
                    if(flag)
                      ans++;  
                }
            }
          return ans;    
    }
    
    public void dfs(int i, int j){
        if(i<0 || i>=temp.length || j<0|| j>=temp[i].length)
            return;
        if(arr[i][j]==1)
        {
            arr[i][j]=0;
            if(temp[i][j]==0)
                flag=false;
            dfs(i+1,j);
            dfs(i-1,j);
            dfs(i,j+1);
            dfs(i,j-1);  
        }
    }
}