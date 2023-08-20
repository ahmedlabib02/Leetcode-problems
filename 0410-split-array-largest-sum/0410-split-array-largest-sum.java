class Solution {
    public int splitArray(int[] nums, int k) {
        int i =0;
        int j=0;
        for(int num:nums)
        {
            i=Math.max(num,i);
            j+=num;
        }
        while(i<j)
        {
            int mid = i+(j-i)/2;
            int ans=0;
            int groups=1;
            int sum=0;
            for(int num:nums)
            {
                if(sum+num>mid)
                {
                    groups++;
                    sum=num;
                }
                else
                    sum+=num; 
            }
            if(groups<=k)
                j=mid;
            else
                i=mid+1;
        }
        return i;
        
    }
}