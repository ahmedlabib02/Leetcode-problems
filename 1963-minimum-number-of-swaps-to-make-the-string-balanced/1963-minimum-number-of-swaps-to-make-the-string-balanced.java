class Solution {
    public int minSwaps(String s) {
        int flag= 0;
        int count =0;
        StringBuilder string = new StringBuilder(s);
        int j = string.length()-1;
        for(int i=0;i<string.length();i++){
            if(string.charAt(i)=='[')
                flag++;
            else 
                flag--;
            if(flag<0){   
                while(string.charAt(j)!='[')
                    j--;
                char t = string.charAt(i);
                string.setCharAt(i,string.charAt(j));
                string.setCharAt(j,t);
                count++;
                flag=1;
            }
                
        }
        return count;
    }
}