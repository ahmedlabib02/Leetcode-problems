class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        
        // two pointers
        int zeros=0;
        int ones=0;
        int ans=0;
        int i=0;
        for(int j=0;j<s.length();j++)
        {
             
            if(s.charAt(j)=='0')
                    zeros++;
                else
                    ones++;
            // System.out.println(i+" "+j);
            while(i<j && zeros>k && ones>k )   
            {
                if(s.charAt(i)=='0')
                    zeros--;
                else
                    ones--;
                i++;
            }
            int len = (zeros+ones);
		    ans += len;
        }
        
        return ans;
    }
}