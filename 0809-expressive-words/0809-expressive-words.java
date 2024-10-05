class Solution {
    public int expressiveWords(String s, String[] words) {
        
        int i=0;
        int[] indicies = new int[words.length];
        
        while(i<s.length())
        {
            char c= s.charAt(i);
            int rep=1;
            while((i+rep)<s.length() && s.charAt(i)==s.charAt(i+rep))
                rep++;
            i=rep+i;
            // System.out.println(i);
            for(int j=0;j<words.length;j++)
            {
                String word = words[j];
                int start = indicies[j];
                
                if(start==-1)
                    continue;
                
                int rep2 =0;
                while((start+rep2)<word.length() && word.charAt(start+rep2)==c)
                {
                    rep2++;
                }
                // System.out.println(rep+" "+rep2);
                if((rep==2 && rep2!=rep) || rep2==0 || rep2>rep)
                {
                   start=-1;
                }
                else
                {
                    start+= rep2;
                }
                
                
                indicies[j]= start;
            }
            for(int v=0;v<indicies.length;v++)
                System.out.print(indicies[v]+" ");
            System.out.println();
            
        }
        int ans=0;
        for(int j=0;j<words.length;j++)
        {
            if(indicies[j] == words[j].length())
                ans++;
        }
        return ans;
           
        
        
    }
}