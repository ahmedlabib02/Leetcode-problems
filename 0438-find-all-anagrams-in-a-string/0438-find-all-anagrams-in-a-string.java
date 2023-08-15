class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] val = new int[26];
        for(char c : p.toCharArray())
            val[c-'a']++;
        
        int i=0;
        int j=0;
        int[] temp = new int[26];
        while(j<s.length())
        {
            
            
            temp[ (int)s.charAt(j)-'a']++;
            
            if(j-i==p.length()-1) 
            {
                if(Arrays.equals(temp,val))
                   ans.add(i);
                temp[(int)s.charAt(i)-'a']--;
                i++;
            }
                j++;
            
        }
        return ans;         
    }
     void print(int[] arr)
     {
         for(int num:arr)
             System.out.print(num+" ");
         System.out.println();
         System.out.println();
     }
}