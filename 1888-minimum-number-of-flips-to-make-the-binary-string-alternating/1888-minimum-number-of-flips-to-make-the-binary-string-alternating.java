class Solution {
    public int minFlips(String s) {
      int n = s.length();
      s = s+s;
      StringBuilder zero= new StringBuilder();
      StringBuilder one =new StringBuilder();
      for(int i=0;i<2*n;i++)  
      {
          if(i%2==0)
          {
              zero.append( '0');
              one.append('1');
          }
          else
          {
              zero.append( '1');
              one.append('0');
          }
      }
      
      int diff1= 0;  
      int diff2 = 0;
      int ans = Integer.MAX_VALUE;
      int left = 0;
      for(int i=0;i<s.length();i++)
      {
          
          if(s.charAt(i)!=one.charAt(i))
              diff2++;
          if(s.charAt(i)!=zero.charAt(i))
              diff1++;
          if(i-left+1>n)
          {
              if(s.charAt(left)!=one.charAt(left))
                  diff2--;
              if(s.charAt(left)!=zero.charAt(left))
                  diff1--;
              left++;
          }
          if(i-left+1==n)
          {
              ans = Math.min(ans,diff1);
              ans = Math.min(ans,diff2);
          }
          
          
      }
    return ans;
        
    }
}