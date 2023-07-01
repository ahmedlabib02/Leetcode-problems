class Solution {
    public int partitionString(String s) {
       int res= 0;
        HashSet<Character> set = new HashSet<Character>();
        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
            else{
                set.clear();
                set.add(s.charAt(i));
                res++;
            }
            
        }
        if(!set.isEmpty())
            res++;
        return res;
       
    }
}