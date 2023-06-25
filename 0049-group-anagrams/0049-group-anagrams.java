class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        
        HashMap<String,ArrayList> map = new HashMap<String,ArrayList>();
        for(String str: strs ){
            char count[] = new char[26];
            for(int i=0;i<str.length();i++){
                count[str.charAt(i)-'a']++;
            }
            String key = new String(Arrays.toString(count));
            if(map.get(key)==null){
                 ArrayList<String>temp = new ArrayList<String>();
                    temp.add(str);
                 map.put(key,temp);
            }
            else{
                map.get(key).add(str);  
            }
              
         }
        for(String key: map.keySet()){
            result.add(map.get(key));
        }
        return (ArrayList)result;
    }
      
    
}