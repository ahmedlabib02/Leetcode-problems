class Solution {
    public int partitionString(String s) {
       int res= 1;
        HashSet<Character> set = new HashSet<Character>();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
               set.clear();
                res++;  
            }
            set.add(s.charAt(i));
        }
        
        return res;
       
    }
}