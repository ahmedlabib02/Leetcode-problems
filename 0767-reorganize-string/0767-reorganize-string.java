class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(Character c : s.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        PriorityQueue<Pair<Character,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(Map.Entry<Character,Integer> entry: map.entrySet())
            pq.add(new Pair<>(entry.getKey(),entry.getValue()));
        Pair<Character,Integer> prev = null;
        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty() || prev!=null)
        {
            if(pq.isEmpty())
                return "";
            Pair<Character,Integer> p = pq.poll();
            Character c = p.getKey();
            int rep = p.getValue();
            if(prev!=null)
                pq.add(prev);
            // if(ans.length()!=0&&c==ans.charAt(ans.length()-1))
            //     return "";
            ans.append(c);
            rep--;
            if(rep!=0)
                prev = new Pair<>(c,rep);
            else prev=null;
        }
        return ans.toString();
        
    }
}