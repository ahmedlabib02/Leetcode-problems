class Solution {
    public String convertToBase7(int num) {
        StringBuilder ans = new StringBuilder();
        boolean flag = num<0;
        if(num==0)
            return "0";
        num=Math.abs(num);
        while(num!=0)
        {
            ans.insert(0,num%7);
            num=num/7;
        }
        if(flag)
        {
            ans.insert(0,"-");
            return ans.toString();
        }
            
        return ans.toString();
    }
}