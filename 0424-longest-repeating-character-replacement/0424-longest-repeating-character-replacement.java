class Solution {
    public int characterReplacement(String s, int k) {
        int length=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int i =0;
        int max= 0;
        for(int j=0;j<s.length();j++)
        {
            
            map.put(s.charAt(j) , map.getOrDefault(s.charAt(j),0)+1 );
            max = Math.max(max,map.get(s.charAt(j)));
            int count = j-i+1-max;
            // System.out.println(map+ " "+count);
            if(count>k)
            {
                
                map.put(s.charAt(i), map.get(s.charAt(i))-1 );
                i++;
            }
            
            length = Math.max(j-i+1,length);
        }
        return length;
    }
}