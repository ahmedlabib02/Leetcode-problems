class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int ans=0;
        for(int j=0;j<s.length();){
            if(set.contains(s.charAt(j))){
                while(i<s.length()&&s.charAt(i)!=s.charAt(j)){
                    set.remove(s.charAt(i));
                    i++;
                    l--;
                } 
                set.remove(s.charAt(i));
                l--;
                i++;
            }
            else{
                l++;
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans,l);
            } 
        }
        return ans;
    }
}