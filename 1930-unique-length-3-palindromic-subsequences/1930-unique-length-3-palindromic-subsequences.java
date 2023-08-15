class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] post = new int[26];
        int[] pre = new int[26];
        for(char c : s.toCharArray())
            post[c-'a']++;
        pre[s.charAt(0)-'a']++;
        post[s.charAt(0)-'a']--;
        int ans= 0;
        HashSet<String> set = new HashSet<>();
        for(int i=1;i<s.length()-1;i++)
        {
            post[s.charAt(i)-'a']--;
            for(int j=0;j<26;j++)
               if(pre[j]!=0 && post[j]!=0)
               {
                   char first = (char)(j+'a');
                   set.add(""+first + s.charAt(i));
               }
                    
            pre[s.charAt(i)-'a']++;
            
            
        }
        return set.size();
        
    }
    
}
