class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = getNum(arr,x);
        ArrayList<Integer> list = new ArrayList<>();
        int i=index;
        int j = index;
        k--;
        while(k!=0)
        {
            if(i==0 )
                j++;
            else if(j==arr.length-1)
                i--;
            else if(x-arr[i-1]>arr[j+1]-x)
                j++;
            else i--;
            k--;    
        }
        for(int y=i;y<=j;y++)
            list.add(arr[y]);
        return list;
    }
    
    public int getNum(int[] nums,int target)
    {
        int i =0;
        int j= nums.length-1;
        while(i+1<j)
        {
            int mid = i+(j-i)/2;
            if(nums[mid]> target)
                j=mid;
            else 
                i=mid;
        }
        if(target-nums[i]>nums[j]-target)
            return j;
        return i;
    }
}