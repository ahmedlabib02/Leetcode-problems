class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        if(s.length()<10)
            return new ArrayList<>();
        HashSet<String> res = new HashSet<String>();
        for(int i=10;i<=s.length();i++){
            if(!set.contains(s.substring(i-10,i)))
                set.add(s.substring(i-10,i));
            else
                res.add(s.substring(i-10,i));
                
        }
        return new ArrayList<>(res);
    }
}