class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        long j=0;
        for(int num: piles)
            j+= num;
        long i = j/h;
        while(i<j)
        {
            long mid = i+(j-i)/2;
            if(isPossible(piles,h,mid))
                j=mid;
            else
                i=mid+1;
        }
        return (int)j;
    }
    public boolean isPossible(int[] arr, int maxHours, long k)
    {
        int hours=0;
        for(int i=0;i<arr.length;i++)
        {
            int num = arr[i];
            if(num<=k)
            {
               hours++;
            }
            else 
            {
                hours+= (int)Math.ceil((double)num/k);
            }
        }
        if(hours>maxHours)
                return false;
        return true;
    }
}