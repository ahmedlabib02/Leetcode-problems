class Solution {
    public int longestMountain(int[] arr) {
        int i=0;
        boolean increasing = true;
        int ans =0;
        for(int j=1;j<arr.length;j++)
        {
            if(arr[j]>arr[j-1] && !increasing)
            {
                ans = Math.max(ans, j-i);
                increasing=true;
                i=j-1;
            }
            else if(arr[j]<arr[j-1] & increasing)
            {
                if(j==i+1)// length less than three reset
                    i=j;
                else
                    increasing=false;
            }
            else if(arr[j]==arr[j-1])
            {
                if(!increasing && j-i>=3)
                    ans = Math.max(ans, j-i);
                increasing = true;
                i=j;
            }
            if(!increasing )
                ans = Math.max(ans, j-i+1);
        }
        return ans;
    }
}