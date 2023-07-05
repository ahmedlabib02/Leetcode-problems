class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())
            return "";
        HashMap<Character,Integer> map= new HashMap<>();
        
        for(int i=0;i<t.length();i++)
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        
        int i=0;
       
        StringBuilder ans = new StringBuilder(s);
        ans.append("0");
        int j =i;
        boolean hasAll= false; 
        while(j<s.length()){
            
            if(hasAll){
                ans = ((j-i)<ans.length())?(new StringBuilder(s.substring(i,j+1))):(ans);
                if(map.get(s.charAt(i))!=null){
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                   
                }
                 if(!noPositives(map)){
                     hasAll=false;
                      map.put(s.charAt(j),map.get(s.charAt(j))+1);
                 }
                        
                 i++;
  
            }
            else if(map.get(s.charAt(j))!=null){
                    map.put(s.charAt(j),map.get(s.charAt(j))-1);
                if(!noPositives(map))
                    j++;
                else hasAll=true;
                
            }
            else {
                j++;
            }
           
               
        }
       
        
        if(ans.length()==s.length()+1)
            return "";
        
        return ans.toString();
    }
               
    public boolean noPositives(HashMap<Character,Integer> nums){
        for(Integer num: nums.values())
            if(num>0)
                return false;
        return true;
    }
}