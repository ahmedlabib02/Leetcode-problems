class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int[] val = new int[26];
        for(char c : s1.toCharArray())
            val[c-'a']++;
        
        int[] temp = new int[26];
        for(int j=0;j<s2.length();j++)
        {
            char c= s2.charAt(j);
            temp[c-'a']++;
            if(j>=s1.length())
            {
                char c2 = s2.charAt( j-s1.length() );
                temp[c2-'a']--;
            }
            if(Arrays.equals(temp,val))
                return true;
        }
        return false;
        
        
    }
}