class Solution {
    public int getSum(int a, int b) {
        int pow = 0;
        int c=0;
        int sum = 0;
        for(int i =0;i<32;i++)
        {
            
            int s = (a&1) ^ (b&1) ^ (c&1);
            c  = (a)&(b) | (b)&c | a&c;
            // System.out.println(s +" "+c);
            sum+= (s&1)<<pow;
            pow++;
            a>>>=1;
            b>>>=1;
        }
        return sum;
    }
}