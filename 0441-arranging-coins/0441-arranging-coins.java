class Solution {
    public int arrangeCoins(int n) {
        int i=1;
        int j=n;
        while(i<=j)
        {
            int mid = i+(j-i)/2;
            long x = (long)mid*(mid+1)/2;
            if(x==n)
                return mid;
            else if(x>n)
                j=mid-1;
            else 
                i= mid+1;
        }
        return j;
    }
}