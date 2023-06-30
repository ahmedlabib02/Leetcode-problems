class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();
        String[] string = s.split(" ");
        if(string.length!=pattern.length())
            return false;
        for(int i=0;i<pattern.length();i++){
            if(map.get(pattern.charAt(i))==null)
                map.put(pattern.charAt(i),string[i]);
            else{
                if(!map.get(pattern.charAt(i)).equals(string[i]))
                    return false;
            }
            if(map2.get(string[i])==null)
                map2.put(string[i],pattern.charAt(i));
            else{
                if(!map2.get(string[i]).equals(pattern.charAt(i)))
                    return false;
            }
            
        }
        return true;
    }
}