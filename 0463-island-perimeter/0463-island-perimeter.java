class Solution {
    int [][] temp;
    boolean[][] seen;
    public int islandPerimeter(int[][] grid) {
        temp = grid;
        seen = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
                if(grid[i][j]==1){
                    return dfs(i,j);
                }
                    
        }
        return 0;
    }
    public int dfs(int i,int j){
        int ans = 4;
        if(i<0 || i>=temp.length || j<0 || j>=temp[i].length|| temp[i][j]==0|| seen[i][j])
            return 0;
        if(temp[i][j]==1)
        {
            if(i!=0 && temp[i-1][j]==1)
            ans--;
            if(i!=temp.length-1 && temp[i+1][j]==1)
            ans--;
            if(j!=0 && temp[i][j-1]==1)
            ans--;
            if(j!=temp[i].length-1 && temp[i][j+1]==1)
            ans--;
            seen[i][j]=true;
           
        }
         return ans + dfs(i-1,j)+ dfs(i+1,j)+ dfs(i,j-1)+ dfs(i,j+1);
    }
}