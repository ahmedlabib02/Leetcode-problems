class Solution {
    public long distinctNames(String[] ideas) {
       HashMap<Character, HashSet<String>> map = new HashMap<>();
        
        for(String idea : ideas){
            StringBuilder sb = new StringBuilder(idea);
            String zeby = sb.substring(1).toString();
            if(map.get(idea.charAt(0))==null){
                HashSet<String> set = new HashSet<>();
                set.add(zeby);
                map.put(idea.charAt(0),set);
            }
            else 
                map.get(idea.charAt(0)).add(zeby);
        } 
        HashSet<Character> done= new HashSet<Character>();
        long res=0;
        for(Character c1 : map.keySet()){
            HashSet<String> set1 = map.get(c1);
            for(Character c2 : map.keySet()){
                if(c1==c2 || done.contains(c2)) continue;
                HashSet<String> set2 = map.get(c2);
                int counter =0;
                for(String s :  set1)
                    if(set2.contains(s))
                        counter++;
                int x = set1.size() - counter;    
                int y = set2.size() - counter;
                res+= (x*y)*2;
            }
            done.add(c1);
            
        }
         
        return res;
    }
}