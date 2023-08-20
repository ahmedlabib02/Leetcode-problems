class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        int i = 0;
        for(int num: spells)
        {
            ans[i++]= potions.length-binarySearch(success, num, potions);
        }
        return ans;
    }
    
    public int binarySearch(long k, int num, int[] arr)
    {
        int i=0;
        int j = arr.length-1;
        while(i<j)
        {
            int mid= i+(j-i)/2;
            long product = (long)num * arr[mid];
            if(product>=k)
                j=mid;
            else
                i=mid+1;
        }
        if((long)num*arr[i] >= k)
            return i;
        return arr.length;
    }
}