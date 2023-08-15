class Solution {
    public int numOfSubarrays(int[] arr, int k, int val) {
        int sum = 0;
        int ans=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+= arr[i];
            // System.out.println(sum);
            double avg = (double)sum/k;
            if(i>=k-1)
            {
                if(avg>=val)
                    ans++;
                sum-= arr[i-k+1]; 
            }
            
        }
        
        return ans;
    }
}