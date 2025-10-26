class Solution {
    public int getMaximumConsecutive(int[] coins) {

        int[] arr = Arrays.copyOf(coins, coins.length+1);
        arr[coins.length]= 0;
        Arrays.sort(arr);
        int i=0;
        int curr = 0;
        int ans=-1;
        for(int j=1;j<arr.length;j++)
        {
            int min = arr[i];
            int lower = arr[j];
            int upper = arr[j]+curr;
            if(curr+1>=lower && curr+1<=upper )
            {
                curr=upper;
            }
            else
            {
                ans= Math.max(ans, curr-min+1);
                i=j;
                curr = min;
            }
        }
        ans= Math.max(ans, curr - arr[i]+1);
        return ans;
    }
}