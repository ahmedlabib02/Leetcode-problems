class Solution {
    public boolean isPerfectSquare(int num) {
        int i =1;
        int j=num;
        while(i<=j)
        {
            // System.out.println(i+" "+j);
            int mid= i+(j-i)/2;
            long x = (long)mid* mid;
            if(x==num)
                return true;
            if(x>num)
                j=mid-1;
            else
                i= mid+1;
        }
        return false;
    }
}