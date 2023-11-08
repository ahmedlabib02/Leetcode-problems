class Solution {
    public String numberToWords(int num) {
        int count =0;
        StringBuilder sb = new StringBuilder();
        while(num!=0)
        {
            int threeDigit = num%1000;
            sb.insert(0,get(threeDigit,count));
            count++;
            num /=1000;
        }
        if(sb.length()!=0)
            sb.deleteCharAt(0);
        else
            return "Zero";
        return sb.toString();
    }
    
    public String get(int num, int count)
    {
        //System.out.println(num);
        StringBuilder ans =new StringBuilder();
        if(num!=0)
        switch(count)
        {
            case 1: ans.append(" Thousand");break;
            case 2: ans.append(" Million");break;
            case 3: ans.append(" Billion");break;
            case 4: ans.append(" Trillion");break;
        }
        ans.insert(0,  getThreeDigit(num));
        return ans.toString();
    }
    
    public String getThreeDigit(int num)
    {
        StringBuilder sb = new StringBuilder();
        if(num/100!=0)
        {
            sb.append(getName(num/100));
            sb.append(" Hundred");
            
        }
        if(num%100!=0)
        {
            sb.append(getTens(num%100)); 
        }
        return sb.toString();
            
    }
    
    public String getTens(int num )
    {
        
        StringBuilder sb = new StringBuilder();
        int ten = num/10;
        int unit = num%10;
        if(ten!=1)
        {
            sb.append(getName(num%10));
        }
        switch(ten)
        {
            case 1: switch(unit)
            {
                case 0: sb.insert(0," Ten");break;
                case 1:sb.insert(0 ," Eleven") ;break;
                case 2:sb.insert(0," Twelve") ;break;
                case 3: sb.insert(0, " Thirteen");break;
                case 4: sb.insert(0 ," Fourteen");break;
                case 5: sb.append( " Fifteen");break;
                case 6: sb.append( " Sixteen");break;
                case 7 : sb.append( " Seventeen");break;
                case 8: sb.append( " Eighteen");break;
                case 9: sb.append( " Nineteen"); break; 
            }
                break;
            case 2: sb.insert(0," Twenty");break;
            case 3: sb.insert(0, " Thirty");break;
            case 4: sb.insert(0 ," Forty");break;
            case 5: sb.insert(0 ," Fifty");break;
            case 6: sb.insert(0, " Sixty");break;
            case 7: sb.insert(0, " Seventy");break;
            case 8 : sb.insert( 0," Eighty");break;
            case 9 : sb.insert(0 ," Ninety");break;
        }
        return sb.toString();
    }
           
    public String getName(int num)
    {
        switch(num)
        {
            case 1: return " One";
            case 2: return " Two";
            case 3: return " Three";
            case 4: return " Four";
            case 5: return " Five";
            case 6: return " Six";
            case 7: return " Seven";
            case 8: return " Eight";
            case 9: return " Nine";
            default : return "";
        } 
    }
    
    
}