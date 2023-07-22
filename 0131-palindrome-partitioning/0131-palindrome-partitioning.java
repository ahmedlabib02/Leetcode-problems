class Solution {
    StringBuilder s;
    public List<List<String>> partition(String s) {
        this.s = new StringBuilder(s);
        List<List<String>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, 0);
        return ans;
    }
    
    public void backtrack(List<String> curr, List<List<String>> ans, int index){
        if(index==s.length())
        {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=index; i<s.length(); i++)
        {
                String temp =s.substring(index,i+1)  ; 
                if(isPalindrome(temp))
                {
                    curr.add(temp);
                    backtrack(curr,ans,i+1);
                    curr.remove(curr.size()-1);  
                }
                
        }
    }
    public  boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
    
}