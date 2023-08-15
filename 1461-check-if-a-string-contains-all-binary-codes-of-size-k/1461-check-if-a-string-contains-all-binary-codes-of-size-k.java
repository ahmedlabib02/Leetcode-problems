class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();
        int needed = (int)Math.pow(2,k);
        
        for(int i=k;i<=s.length();i++)
        {
            
            String temp=  s.substring(i-k,i);
            if(!set.contains(temp))
            {
                set.add(temp);
                needed--;
            }
            if(needed==0)
                return true;
        }
        return needed==0;
    }
}