class Solution {
    public int[] asteroidCollision(int[] arr) {
      Stack<Integer> s = new Stack<>();  
      for(int num: arr)
      {
          if(num>0)
              s.push(num);
          else if(num<0 && (s.isEmpty() || s.peek()<0))
              s.push(num);
          else 
          {
              int curr= Math.abs(num);
              while(!s.isEmpty() && curr>s.peek() && s.peek()>0)
                s.pop();  
              if(s.isEmpty()|| s.peek()<0)
                  s.push(num);
              else if(s.peek()+num==0)
                  s.pop();
          }
      }
      int[] ans  = new int[s.size()];
        int i=0;
        for(int num: s)
            ans[i++]= num;
        return ans;
    }
    
}