class Solution {
    public String solveEquation(String equation) {
        int sum =0;
        int coe= 0;
        StringBuilder sb = new StringBuilder(equation);
        int sign = 1;
        int i=0;
        while(i<equation.length())
        {
            char c= sb.charAt(i);
            if(c=='=')
            {
                sign =-1;
            }
            else if(c>='0' && c<='9')
            {
                int j=i+1;
                while(j<sb.length() && sb.charAt(j)>='0' && sb.charAt(j)<='9')
                {
                     j++; 
                }
                int currSign =1;
                if(i!=0 && sb.charAt(i-1)=='-')
                    currSign = -1;
                
                String sub = sb.substring(i,j);
                int num = Integer.parseInt(sub);
                if(j!=sb.length()&& sb.charAt(j)=='x')
                {
                    coe+=num*currSign*sign;
                    j++; 
                }
                else
                   sum+= num*currSign*sign;;
                
                i=j-1;
            }
            else if(c=='x')
            {
                int currSign =1;
                if(i!=0 && sb.charAt(i-1)=='-')
                    currSign = -1;
                coe += currSign*sign;
            }
            i++;
        }
        System.out.println(coe+" "+sum);
        if(coe==0&& sum!=0)
            return "No solution";
        if(coe==0)
            return "Infinite solutions";
        
        sum=sum*-1;
        
        
        return "x="+(sum/coe);
        
    }
}