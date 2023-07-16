class Solution {
    char[][] temp;
    public int numIslands(char[][] grid) {
        int ans=0;
        temp = grid;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(temp[i][j]=='1')
                {
                    ans++;
                    dfs(i,j);
                }
                    
            }
            if(i==1)
                printMap();
        }
        return ans;
    }
    
    public void dfs(int i, int j){
        if(temp[i][j]=='1')
        {
            temp[i][j]= '2';
            if(i!=temp.length-1)
                dfs(i+1,j);
            if(i!=0)
                dfs(i-1,j);
            if(j!=temp[i].length-1)
                dfs(i,j+1);
            if(j!=0)
                dfs(i,j-1);
        }
    }
    
    public void printMap(){
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[i].length;j++){
                System.out.print(temp[i][j]+" ");
            }
            System.out.println();
        }
            
        
    }
}