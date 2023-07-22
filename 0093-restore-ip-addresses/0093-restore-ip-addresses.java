class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack( new StringBuilder(s), ans, 0, 0);
        return ans;
    }
    
    public void backtrack(StringBuilder s, List<String> ans, int index, int num){
        if(num==3)
        {
            String temp = s.substring(index,s.length());
            if(check(temp))
                ans.add(s.toString());
            return;
        }
        for(int i=index; i<index+3 && i<s.length() ;i++)
        {
            
            String temp= s.substring(index,i+1);
            System.out.println(s);
            if(check(temp))
            {
                
                s.insert(i+1,'.');
                backtrack(s,ans,i+2,num+1);
                s.delete(i+1,i+2);
                

            }
        }
        
    }
    public boolean check(String s){
       if(s.equals(""))
           return false;
        if(s.length()>3)
            return false;
        int num = Integer.parseInt(s);
        if(s.charAt(0)=='0' && s.length()>1)
            return false;
        if(num<=255 && num>=0)
            return true;
        return false;
    }
}