class Solution {
    public int orangesRotting(int[][] grid) {
     int ans= 0;
     Queue<Pair<Integer,Integer>> q = new LinkedList<>();   
     HashSet<Pair<Integer,Integer>> fresh = new HashSet<>();   
     for(int i=0;i<grid.length;i++)
       {
           for(int j=0;j<grid[i].length;j++)
           {
                if(grid[i][j]==2)
                    q.add(new Pair<Integer,Integer>(i,j));
               if(grid[i][j]==1)
                   fresh.add(new Pair<Integer,Integer>(i,j));
           }
       }
        if(fresh.isEmpty())
            return 0;
        int step=0;
        while(!q.isEmpty())
        {
            System.out.print(q);
            System.out.println(fresh);
            step++;
            int size = q.size();
            for(int x=0;x<size;x++)
            {
                Pair<Integer,Integer> pair = q.remove();
                int i = pair.getKey();
                int j = pair.getValue();
                if(fresh.contains(new Pair<Integer,Integer>(i-1,j)))
                {
                    fresh.remove(new Pair<Integer,Integer>(i-1,j));
                    q.add(new Pair<Integer,Integer>(i-1,j));
                }
                    
                if(fresh.contains(new Pair<Integer,Integer>(i+1,j)) )
                {
                    fresh.remove(new Pair<Integer,Integer>(i+1,j));
                    q.add(new Pair<Integer,Integer>(i+1,j));
                }
                    
                if(fresh.contains(new Pair<Integer,Integer>(i,j-1)))
                {
                    fresh.remove(new Pair<Integer,Integer>(i,j-1));
                    q.add(new Pair<Integer,Integer>(i,j-1));
                }
                if(fresh.contains(new Pair<Integer,Integer>(i,j+1)) )
                {
                    fresh.remove(new Pair<Integer,Integer>(i,j+1));
                    q.add(new Pair<Integer,Integer>(i,j+1));
                }
                    
                
            }
        }
        if(!fresh.isEmpty())
            return -1;
        return step-1;
    }
}