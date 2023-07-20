class Solution {
    public int minDays(int n) {
      Queue<Integer> q = new LinkedList<>(); 
      q.add(n);
      int step =-1;
      HashSet<Integer> set = new HashSet<>();
      set.add(n);
      while(!q.isEmpty())
      {
          
          
          step++;
          int size= q.size();
          for(int i=0;i<size;i++)
          {
              int node = q.remove();
              if(node==0)
                return step;
              if(!set.contains(node-1))
              {
                  set.add(node-1);
                  q.add(node-1);
              }
                  
              if(node%2==0 && !set.contains(node/2))
              {
                  set.add(node/2);
                  q.add(node/2);
              }
                  
              if(node%3==0 && !set.contains(node/3))
              {
                  set.add(node/3);
                  q.add(node/3);
              }   
          } 
      }
      return step;  
    }
}