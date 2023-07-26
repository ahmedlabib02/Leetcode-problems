class Solution {
    HashSet<String> dictionary;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        dictionary = new HashSet<>(Arrays.asList(words));
        List<String> ans = new ArrayList<>();
        for(String s : words)
        {
            int dp[] = new int[s.length()];
            if(s.length()!=1&& dp(0,s,new boolean[s.length()]))
                    ans.add(s);
                   
            
        }
         return ans; 
    }
    public boolean dp(int start, String s,boolean[] visited)
    {
        if(visited[start])
            return false;
        visited[start]=true;
        for(int i=start+1;i<s.length();i++)
        {
            if(dictionary.contains(s.substring(start,i)) )
            {
                if(dictionary.contains(s.substring(i)))
                   return true;
                if(dp(i,s,visited))
                    return true;
            }
                 
        }
        return false;
    }
}