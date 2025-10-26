class Solution {
    public int getMaximumConsecutive(int[] arr) {
        Arrays.sort(arr);
        int i=-1;
        int min=0;
        int curr = 0;
        int ans=-1;
        for(int j=0;j<arr.length;j++)
        {
            min = i==-1?0:arr[i];
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
        ans= Math.max(ans, curr - min +1);
        return ans;
    }
}