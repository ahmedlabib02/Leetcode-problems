public class state {
    String word ;
    int step;
    public state(String word, int step)
    {
        this.word=word;
        this.step= step;
    }
}

class Solution {
    HashMap<String, ArrayList<String>> map;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        map = new HashMap<>();
        map.put(beginWord, new ArrayList<>());
        for(String s : wordList)
        {
            if(oneStep(beginWord,s))
            {
                map.get(beginWord).add(s);
            }
        }
        for(int i=0;i<wordList.size();i++)
        {
            if(map.get(wordList.get(i))==null)
                map.put(wordList.get(i), new ArrayList<>());
            for(int j=i+1;j< wordList.size();j++)
            {
                if(map.get(wordList.get(j))==null)
                    map.put(wordList.get(j), new ArrayList<>());
                if(oneStep(wordList.get(i), wordList.get(j)))
                {
                    map.get(wordList.get(i)).add(wordList.get(j));
                    map.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }
        Queue<state> q = new LinkedList<>();
        q.add(new state(beginWord,1));
        HashSet<String> seen= new HashSet<>();
        seen.add(beginWord);
        while(!q.isEmpty())
        {
            state s = q.remove();
            String w = s.word;
            if(w.equals(endWord))
                return s.step;
            for(String word : map.get(w))
            {
                if(!seen.contains(word))
                {
                    seen.add(word);
                    q.add(new state(word,s.step+1));
                }
            }
        }
        
        return 0;
            
    }
    
    public boolean oneStep(String s1, String s2){
        boolean flag= false;
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)!=s2.charAt(i)&& flag)
                return false;
            if(s1.charAt(i)!=s2.charAt(i))
                flag=true;     
        }
        return true;
    }
}