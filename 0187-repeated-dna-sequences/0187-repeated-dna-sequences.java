class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        if(s.length()<10)
            return new ArrayList<>();
        HashSet<String> res = new HashSet<String>();
        for(int i=9;i<s.length();i++){
            if(!set.contains(s.substring(i-9,i+1)))
                set.add(s.substring(i-9,i+1));
            else
                res.add(s.substring(i-9,i+1));
                
        }
        return new ArrayList<>(res);
    }
}