public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int pow = 31;
        int ans=0;
        while(n!=0)
        {
            ans+= (n&1)<<pow;
            n = n >>>1;
            pow--;
        }
        return ans;
    }
}