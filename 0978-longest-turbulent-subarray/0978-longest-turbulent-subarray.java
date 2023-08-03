class Solution {
    public int maxTurbulenceSize(int[] arr) {
        boolean asc=true;
        if(arr.length==1)
            return 1;
        if(arr[0]>arr[1])
            asc=false;
        int i = 0;
        int ans = 1; // Initialize ans to 1, as a single element is considered a valid sequence
        int count = 1;

        while (i < arr.length - 1) {
            if(arr[i] < arr[i + 1]) 
            {
                if (asc) 
                {
                    count++;
                    asc=false;
                }   
                else 
                {
                    ans= Math.max(count,ans);
                    count = 2;
                }
                    
            } 
            else if(arr[i] > arr[i + 1]) 
            {
                if (!asc) 
                {
                    count++;
                    asc=true;
                    
                } 
                else
                {
                    ans=Math.max(count,ans);
                    count = 2; 
                }
            } 
            else 
            {
                ans=Math.max(count,ans);
                count=1;
                if(i<arr.length-2&&arr[i+1]>arr[i+2])
                    asc=false;
                else
                    asc=true;
            }
            i++;
            
        }
        ans =Math.max(count,ans);
        return ans;
    }
}
