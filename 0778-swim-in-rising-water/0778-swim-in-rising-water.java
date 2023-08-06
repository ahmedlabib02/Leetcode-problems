class Solution {
    int n;
    int m;
    int directions[][] = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int swimInWater(int[][] grid) {
        n= grid.length;
        m= grid[0].length;
        int[][] time = new int[n][m];
        for(int[] x :time)
            Arrays.fill(x, Integer.MAX_VALUE);
        time[0][0]= grid[0][0];
        Queue<Cell> q  = new LinkedList<>();
        q.add(new Cell(0,0,grid[0][0]));
        while(!q.isEmpty())
        {
            
            Cell curr= q.remove();
            int x= curr.x;
            int y = curr.y;
            int weight = curr.time;
            for(int[] step: directions)
            {
                int xx = x+ step[0];
                int yy= y+ step[1];
                if(valid(xx,yy))
                {
                    int elev= grid[xx][yy];
                    int currTime = Math.max(elev,weight);
                    if(currTime<time[xx][yy])
                    {
                        time[xx][yy]= currTime;
                        q.add(new Cell(xx,yy,currTime));
                    }
                }
            }
        }
        // print(time);
         return time[n-1][m-1];  
    }
    public void print(int[][] arr)
    {
        for(int[] x: arr)
        {
            for(int num:x)
                System.out.print(num+" ");
            System.out.println();
        }
    }
    
    public boolean valid(int x,int y)
    {
        if(x>=n || y>=m || x<0 || y<0)
            return false;
        return true;
    }
    
}
public class Cell 
{
    int x;
    int y;
    int time;
    public Cell(int x, int y, int time)
    {
        this.x=x;
        this.y=y;
        this.time=time;
    }
     public String toString() {
        return "Cell: (" + x + ", " + y + "), time: " + time;
    }
}