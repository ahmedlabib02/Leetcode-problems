class Solution {
     int n;
     int[] arr;
    public boolean canCross(int[] stones) { // Frog Jump
            n = stones.length;
            arr = stones;
            Boolean[][] memo = new Boolean[n+1][n+1];
            return dp(0,1,memo);
    }

    public boolean dp(int index, int jump, Boolean[][] memo){
        
        if(index<0||jump<0||index>arr[n-1] )
            return false;
        if(index==n-1)
            return true;
        if(memo[index][jump]!=null)
            return memo[index][jump];
        int i=index;
        int j=n-1;
        int nextIndex=-1;
        while(i<=j)
        {
            int mid = i+(j-i)/2;
            if(arr[mid]==(jump+arr[index]))
            {
                nextIndex= mid;
                break;
            }   
            if(arr[mid]>(jump+arr[index]))
                j = mid-1;
             else
               i= mid+1;
        }
        // System.out.println(index+" "+jump+" "+nextIndex);
        
        if(nextIndex==-1 )
            memo[index][jump]=false;
        else
        {
            memo[index][jump] = dp(nextIndex, jump+1, memo) ;
            memo[index][jump]|= dp(nextIndex, jump-1, memo);
            if(index!=nextIndex)
                memo[index][jump]|=dp(nextIndex, jump, memo);
        }
        return memo[index][jump];
    }
}