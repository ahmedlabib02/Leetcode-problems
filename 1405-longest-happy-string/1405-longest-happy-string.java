class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair<Character,Integer>> pq = new PriorityQueue<>((x,y)->y.getValue()-x.getValue());
        Pair<Character,Integer> pa = new Pair<>('a',a);
        Pair<Character,Integer> pb = new Pair<>('b',b);
        Pair<Character,Integer> pc = new Pair<>('c',c);
        if(pa.getValue()!=0)
        pq.add(pa);
        if(pb.getValue()!=0)
        pq.add(pb);
        if(pc.getValue()!=0)
        pq.add(pc);
        StringBuilder sb= new StringBuilder();
        Pair<Character,Integer> prev = null;
        while(!pq.isEmpty())
        {
            
            Pair<Character,Integer> pair = pq.poll();
            if(prev!=null)
                pq.offer(prev);
            Character cc = pair.getKey();
            if(sb.length()!=0 &&cc==sb.charAt(sb.length()-1))
                return sb.toString();
            int rep = pair.getValue();
            int x=Math.min(rep,2);
            if(!pq.isEmpty() && rep-x<pq.peek().getValue())
                x= 1;
            for(int i =0;i<x;i++)
                sb.append(cc);
            rep-= x;
            if(rep!=0)
                prev=new Pair<>(cc,rep);
            else
                prev = null;
        }
        return sb.toString();
    }
}