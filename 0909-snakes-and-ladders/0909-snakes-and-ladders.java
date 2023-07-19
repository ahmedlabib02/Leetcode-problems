public class state {
    int square;
    int step;
    public state(int square, int step){
        this.square= square;
        this.step = step;
    }
}
class Solution {
    public int snakesAndLadders(int[][] grid) {
        Queue<state> q = new LinkedList<>();
        q.add(new state(1,0));
        boolean[][] seen = new boolean[grid.length][grid.length];
        seen[grid.length-1][0]= true;
        HashMap<Integer,Pair<Integer,Integer>> map = new HashMap<>();
        int counter=1;
        for(int i=grid.length-1;i>=0;i--)
        {
            if((grid.length-i-1)%2==0)
            {
                for(int j=0;j<grid.length;j++)
                    map.put(counter++,new Pair<Integer,Integer>(i,j));
            }
            else 
            {
                for(int j=grid.length-1;j>=0;j--)
                    map.put(counter++,new Pair<Integer,Integer>(i,j));
            }
        }
        System.out.print(map);
        while(!q.isEmpty())
        {
            state s = q.remove();
            int square = s.square;
            int step= s.step;
            
            // System.out.println(square+" "+step);
            
            if(square==grid.length*grid.length)
                return s.step;
            for(int i=square+1;i<=square+6;i++)
            {
                int row = map.get(i).getKey();
                int col = map.get(i).getValue();
                if(grid[row][col]!=-1)
                    {
                        int num = grid[row][col];
                        int rrow = map.get(num).getKey();
                        int ccol= map.get(num).getValue();
                        if(!seen[rrow][ccol])
                        {
                           seen[rrow][ccol]=true; 
                           q.add(new state(num,step+1));  
                        }
                     }
                        else if(!seen[row][col])
                        {
                            seen[row][col]= true;
                            q.add(new state(i,step+1));
                        }
               
                    if(i == grid.length*grid.length)
                    break; 
                    
            }
        }
        return -1;
    }
}