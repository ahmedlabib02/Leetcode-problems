public class state {
    char[] arr;
    int step;
    public state(char[] arr,int step){
        this.arr = arr;
        this.step = step;
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(char c : arr)
            sb.append(c);
        return sb.toString();
    }
        
    
}

class Solution {
    public int openLock(String[] deadends, String target) {
       
        Queue<state> q = new LinkedList<>();
        char[] temp = new char[]{'0','0','0','0'};
        q.add(new state(temp,0));
        HashSet<String> end = new HashSet<>();
        HashSet<String> set = new HashSet<>();
        for(String deadend : deadends)
            end.add(deadend);
        if(end.contains("0000"))
            return -1;
        set.add(concat(temp));
        while(!q.isEmpty())
        {
            state s= q.remove();
            char[] a = s.arr;
            if(concat(a).equals(target))
                return s.step; 
            // System.out.println( concat(a) +" "+ q );
            
            for(int i=0;i<target.length();i++)
            {   
               char[] dec = Arrays.copyOf(a,a.length);
               char[] inc = Arrays.copyOf(a,a.length);
                if(dec[i]=='0')
                   dec[i]= '9';
                else 
                    dec[i]= (char)(dec[i]-1);
                if(inc[i]=='9')
                    inc[i]='0';
                else
                    inc[i] = (char)(inc[i]+1);
                String s1 = concat(dec);
                String s2 = concat(inc);
                if(s1.equals(target)||s2.equals(target))
                    return s.step+1;
               if(!set.contains(s1) && !end.contains(s1))
               {
                   set.add(s1);
                   q.add(new state(dec,s.step+1));
               }
               if(!set.contains(s2) && !end.contains(s2))
               {
                   set.add(s2);
                   q.add(new state(inc,s.step+1));
               }
            }
            
        }
        return -1;
    }
    
    public String concat(char[] arr)
    {
        StringBuilder sb = new StringBuilder();
        for(char c : arr)
            sb.append(c);
        return sb.toString();
    }
}