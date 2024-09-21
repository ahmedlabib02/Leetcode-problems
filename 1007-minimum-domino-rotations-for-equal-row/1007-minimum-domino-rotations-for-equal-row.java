class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<7;i++)
        {
           int t = 0;
            int b= 0;
           for(int j=0;j<tops.length;j++)
           {
               if(tops[j]!=i && bottoms[j]!=i)
               {
                   t = Integer.MAX_VALUE;
                   b = Integer.MAX_VALUE;
                   break;
               }
               if(tops[j]!=i && bottoms[j]==i)
                   t++;
               if(tops[j]==i && bottoms[j]!=i)
                   b++;
           }
            ans =Math.min(ans,b);
            ans = Math.min(ans,t);
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
        
    }
}