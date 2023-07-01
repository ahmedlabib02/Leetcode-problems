class Solution {
    public String pushDominoes(String dominoes) {
       int[] force= new int[dominoes.length()]; 
        for(int i=0;i<dominoes.length();){
            
            if(dominoes.charAt(i)=='R'){
                force[i]=1;
                i++;
                int maxForce = dominoes.length()-1;
                while(i<dominoes.length()&&dominoes.charAt(i)=='.'){
                    force[i]+=maxForce;
                    maxForce--;
                    i++;
                }      
            }
            else i++;
            
        }
        
        for(int i=dominoes.length()-1;i>=0;){
            if(dominoes.charAt(i)=='L'){
                force[i]=-1;
                i--;
                int maxForce = dominoes.length()-1;
                while(i>=0&& dominoes.charAt(i)=='.'){
                    force[i]-=maxForce;
                    maxForce--;
                    i--;
                }
                    
            }
            else i--;
            
        }
        StringBuilder ans = new StringBuilder();
        for (int f: force)
            ans.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
        return ans.toString();
    
    }
}