class Solution {
    public boolean isSubsequence(String s, String t) {
        int j=0;
        for(int i=0;i<s.length();i++) {
            boolean flag= false;
            while(j<t.length()&& !flag){
                if(s.charAt(i)==t.charAt(j))
                    flag=true;
                j++;
            }
                
        
            if(!flag)
                return false;
    }
        return true;
    }
}