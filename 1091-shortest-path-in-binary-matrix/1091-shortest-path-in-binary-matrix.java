public class State{
    int col;
    int row;
    int step;
    public State(int col,int row,int step){
        this.col= col;
        this.row= row;
        this.step=step;
    }
}

class Solution {
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)
            return -1;;
        Queue<State> q = new LinkedList<>();
        State s=new State(0,0,1);
        q.add(s);
        grid[0][0]=1;
        while(!q.isEmpty())
        {
            State temp = q.remove();
            
            if(temp.col==grid.length-1 && temp.row==grid.length-1)
                return temp.step;
            
            if(temp.col!=grid.length-1 && grid[temp.col+1][temp.row]==0){
                grid[temp.col+1][temp.row]=1;
                q.add(new State(temp.col+1, temp.row, temp.step+1));
            }
                
            
            if(temp.col!=0 &&grid[temp.col-1][temp.row]==0)
            {
                grid[temp.col-1][temp.row]=1;
                q.add(new State(temp.col-1, temp.row, temp.step+1));
            }
               
            
            if(temp.row!=grid.length-1 && grid[temp.col][temp.row+1]==0)
            {
                grid[temp.col][temp.row+1]=1;
                q.add(new State(temp.col, temp.row+1, temp.step+1));
            }
               
            if(temp.row!=0&& grid[temp.col][temp.row-1]==0){
                grid[temp.col][temp.row-1] = 1;
                q.add(new State(temp.col, temp.row-1, temp.step+1));
            }
            
            
            
            if(temp.col!=grid.length-1&& temp.row!=grid.length-1&& grid[temp.col+1][temp.row+1]==0){
                grid[temp.col+1][temp.row+1]=1;
                q.add(new State(temp.col+1, temp.row+1, temp.step+1));
            }
                
            if(temp.col!=grid.length-1 && temp.row!=0 &&grid[temp.col+1][temp.row-1]==0){
                grid[temp.col+1][temp.row-1]=1;
                q.add(new State(temp.col+1, temp.row-1, temp.step+1));

            }
            
            if(temp.col!=0&&temp.row!=grid.length-1 && grid[temp.col-1][temp.row+1]==0){
                grid[temp.col-1][temp.row+1]=1;
                q.add(new State(temp.col-1, temp.row+1, temp.step+1));
            }
            if(temp.col!=0 && temp.row!=0 && grid[temp.col-1][temp.row-1]==0){
                grid[temp.col-1][temp.row-1]=1;
                q.add(new State(temp.col-1,temp.row-1,temp.step+1));

            }
                
                
        }
        return -1;
    }
}