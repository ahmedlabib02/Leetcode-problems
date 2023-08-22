class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            @Override 
            public int compare(String s, String t){
                int i=0;
                if(s.length()!=t.length())
                    return t.length()-s.length();
                while(i<s.length() && i<t.length())
                {
                    char cs = s.charAt(i);
                    char ct = t.charAt(i);
                    if(cs!=ct)
                        return ct-cs;
                    i++;
                }
                return 0;
            }
        });
        
        for(String s : nums)
        {
            pq.add(s);
            
        }
        for(int i=0;i<k-1;i++)
            pq.poll();
        // while(!pq.isEmpty())
        //     System.out.println(pq.poll());
        return pq.peek();
            
        
    }
}