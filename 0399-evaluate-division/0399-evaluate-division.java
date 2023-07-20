public class state {
    String src;
    String dst;
    int i;
    double val;
    public state (String src, String dst, int i, double val){
        this.src = src; 
        this.dst = dst;
        this.i = i;
        this.val = val;
    }
    public String toString(){
        return i+" { "+ src +" -> "+ dst +" : "+ val+" }"; 
    }
}

class Solution {
    HashMap<Pair<String,String>, Double> vals;
    HashMap<String,ArrayList<String>> map;
    HashSet<Pair<String,String>> seen;
    HashSet<String> vars ;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        vals = new HashMap<>();
        map = new HashMap<>();
        vars = new HashSet<>();
        for(int i=0;i<equations.size();i++)
        {
            List<String> eq = equations.get(i);
            if(map.get(eq.get(0))==null)
                map.put(eq.get(0),new ArrayList<>());
            if(map.get(eq.get(1))==null)
                map.put(eq.get(1),new ArrayList<>());
            vars.add(eq.get(0));
            vars.add(eq.get(1));
            map.get(eq.get(0)).add(eq.get(1));
            map.get(eq.get(1)).add(eq.get(0));
            vals.put(new Pair<String,String>(eq.get(0),eq.get(1)),values[i]);
            vals.put(new Pair<String,String>(eq.get(1),eq.get(0)),1.0/values[i]);
        }
        double[] ans = new double[queries.size()];
        // for(int i =0;i<ans.length;i++)
        //     ans[i]=-1;
        seen = new HashSet<>();
        for(int i=0;i<queries.size();i++)
        {
            List<String> query = queries.get(i);
            seen.clear();
            state s = new state(query.get(0),query.get(1),i,1);
            ans[i] = dfs(s);
            
        }
        return ans;
        
    }
    public double dfs(state s ){
        if(s.src.equals(s.dst) && vars.contains(s.src))
            return s.val;
        if(map.get(s.src)!=null)
        for(String num : map.get(s.src))
        {
            Pair<String,String> pair = new Pair<String,String>(s.src,num);
            // System.out.println(s);
            // System.out.print(vals);
            if(vals.get(pair)!=null && !seen.contains(pair))
            {
                seen.add(pair);
                double x = dfs(new state(num,s.dst,s.i,s.val*vals.get(pair)));
                if(x!=-1)
                   return x;  
                  
            }
        }
        return -1;
    }
           
}