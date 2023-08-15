class Solution {
    public int maxArea(int[] arr) {
        int i=0;
        int j=arr.length-1;
        int ans = 0;
        while(i<j)
        {
            int x = arr[i];
            int y = arr[j];
            int num = Math.min(arr[i],arr[j]) *(j-i);
            ans= Math.max(ans,num);
            if(x<y)
                i++;
            else if(x>y)
                j--;
            else 
            {
                i++;
                j--;
            }
                
            
        }
        return ans;
    }
}