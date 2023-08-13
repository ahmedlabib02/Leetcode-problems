class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(Character c : text.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);
        
        int ans= Integer.MAX_VALUE;
        for(Character c : "balon".toCharArray())
        {
            int count = map.getOrDefault(c,0);
            if(c=='l' || c=='o')
               count/=2;
            ans = Math.min(ans,count);
        }
        return ans;
    }
}