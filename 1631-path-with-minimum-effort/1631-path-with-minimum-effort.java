class Solution {
    int direction[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int column = heights[0].length;
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>((a, b) -> (a.diff.compareTo(b.diff)));
        boolean[][] visited = new boolean[row][column];
        queue.add(new Cell(0,0,0));
        visited[0][0]=true;
        int[][] diff = new int[row][column];
        for(int[] x: diff)
            Arrays.fill(x,Integer.MAX_VALUE);
        diff[0][0]=0; 
        
        while(!queue.isEmpty())
        {
            Cell curr = queue.remove();
            int x= curr.x;
            int y= curr.y;
            int effort= curr.diff;
            visited[x][y]=true;
            for(int[] step :direction)
            {
                
                int newX= x+step[0];
                int newY = y+step[1];
                if( validCell(newX,newY,visited) )
                {
                    int newDiff = Math.abs(heights[newX][newY]-heights[x][y]);
                    int maxDiff = Math.max(newDiff, effort);
                    if(maxDiff<diff[newX][newY])
                    {
                        diff[newX][newY] = maxDiff;
                        queue.add(new Cell(newX,newY,maxDiff));
                    }
                }
            }
        }
        
        return diff[row-1][column-1];
        
    }
    
    public boolean validCell(int x , int y , boolean[][] visited)
    {
        if(x<0|| y>=visited[0].length|| y<0|| x>=visited.length)
            return false;
        if(visited[x][y])
            return false;
        return true;
    }
    public class Cell
    {
        int x;
        int y;
        Integer diff;
        public Cell(int x, int y,int diff)
        {
            this.x= x;
            this.y= y;
            this.diff=diff;
        }
         public String toString() {
        return "Cell: (" + x + ", " + y + "), diff: " + diff+" ";
    }
    }
}