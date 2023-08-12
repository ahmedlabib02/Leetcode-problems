class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int count=0;
        
            
        for(int i=0;i<arr.length;)
        {
            if(arr[i]==0 && (i==arr.length-1||arr[i+1]==0))
            {
                count++;
                i+=2;
            }
            else if(arr[i]==1)
                i+=2;
            else i++;
            if(count>=n)
                return true;
        }
            
            
        return false;
    }
}