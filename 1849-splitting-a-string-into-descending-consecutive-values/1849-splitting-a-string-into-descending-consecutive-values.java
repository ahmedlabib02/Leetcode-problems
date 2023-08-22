import java.math.BigInteger;
class Solution {
    String s;
    public boolean splitString(String s) {
        this.s= s;
        return backtrack(0,"");
    }
    public boolean backtrack(int index, String prev)
    {
        if(index==s.length())
            return true;
        
        for(int i=index;i<s.length();i++)
        {
            String temp = s.substring(index,i+1);
            if(prev.equals("") )
            {
               if(i!=s.length()-1&&backtrack(i+1,temp))
                   return true;
            }
            else
            {
               BigInteger x = new BigInteger(prev);
               BigInteger y = new BigInteger(temp);
                BigInteger diff = x.subtract(y);
                if(diff.equals(BigInteger.ONE))
                {
                    if(backtrack(i+1,temp))
                        return true;
                }
            }
            
        }
        return false;
    }
}