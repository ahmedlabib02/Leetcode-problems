class Solution {
    public String toHex(int num) {
        
        if(num==0)
            return "0";
        int i =7;
        int max = num/16;
        StringBuilder ans = new StringBuilder();
        while(true)
        {
            int shift =num>>(i*4)&0xf;
            if(shift!=0)
            {
                break;
            }
            i--;
                
        }
        while(i>=0)
        {
            int shift = num>>(i*4) &0xf ;
            ans.append(convert(shift));
            // System.out.println(shift);
            i--;
        }
        return ans.toString();
    }
    public String convert(int num)
    {
        switch(num)
        {
            case 10 : return "a";
            case 11 : return "b";
            case 12: return "c";
            case 13: return "d";
            case 14: return "e";
            case 15: return "f";
        }
        return ""+num;
    }
}