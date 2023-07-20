public class state {
    int step;
    String gene;
    public state(String gene, int step){
        this.gene= gene;
        this.step= step;
    }
}

class Solution {
    
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        map.put(startGene, new ArrayList<>());
        for(int i=0;i<bank.length;i++)
        {
             map.put(bank[i],new ArrayList<>());
            if(oneStep(startGene,bank[i]))
                map.get(startGene).add(bank[i]); 
        }
        for(int i =0;i<bank.length;i++)
        {
            for(int j=i+1;j<bank.length;j++)
            {
                if(!bank[i].equals(bank[j])&& oneStep(bank[i],bank[j]))
                {
                    map.get(bank[i]).add(bank[j]);
                    map.get(bank[j]).add(bank[i]);
                }
            }
        }
        System.out.print(map);
        Queue<state> q = new LinkedList<>();
        q.add(new state(startGene,0));
        HashSet<String> seen = new HashSet<>();
        seen.add(startGene);
        while(!q.isEmpty())
        {
            state s = q.remove();
            if(s.gene.equals(endGene))
                return s.step;
            for(String gene : map.get(s.gene))
            {
                if(!seen.contains(gene) )
                {
                 seen.add(gene);
                 q.add(new state(gene,s.step+1));
                }
            }
        }
        return -1;
        
    }
    
    public boolean oneStep(String s1, String s2)
    {
        boolean flag= false;
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)!=s2.charAt(i) && flag)
                return false;
            if(s1.charAt(i)!=s2.charAt(i))
                flag = true;
        }
        return true;
    }
}