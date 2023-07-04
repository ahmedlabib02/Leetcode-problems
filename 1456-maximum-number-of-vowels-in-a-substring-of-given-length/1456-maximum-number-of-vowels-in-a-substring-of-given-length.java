class Solution {
    public int maxVowels(String s, int k) {
        int i=0;
        int count=0;
        int ans=0;
        for(;i<s.length();){
            if(isVowel(s.charAt(i)))
                break;
            
            i++;
        }
        int j=i;
        for(;j<k+i&&j<s.length();j++)
            if(isVowel(s.charAt(j)))count++;
        System.out.println(i+" "+count);
        ans=count;
        if(ans==k)
            return k;
        j=i+k-1;
        while(j<s.length()){
            System.out.print(s.charAt(i)+"--"+s.charAt(j)+" ");
            if(isVowel(s.charAt(i)))
                count--;
            i++;
            j++;
            if(j<s.length()&&isVowel(s.charAt(j)))
                count++;
            ans = Math.max(ans,count);    

        }
        return ans;
        
    }
   public boolean isVowel(char c){
       switch(c){
           case 'a': case 'e': case'i': case 'o': case 'u': return true;
       } 
       return false;
   }
}