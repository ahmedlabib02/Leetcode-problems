class Solution {
    public int[] intersection(int[] num1, int[] num2) {
        if(num1.length<num2.length)
            return intersection(num2,num1);
        HashSet<Integer> ans = new HashSet<>();
        Arrays.sort(num2);
        for(int num:num1)
        {
            if(ans.contains(num))
                continue;
            if(binarySearch(num,num2))
                ans.add(num);
        }
        int[] arr= new int[ans.size()];
        int count=0;
        for(int num: ans)
            arr[count++]= num;
        return arr;
    }
    public boolean binarySearch(int x , int[] arr)
    {
        int i=0;
        int j= arr.length-1;
        while(i<=j)
        {
            int mid = i+(j-i)/2;
            if(arr[mid]==x)
                return true;
            else if(arr[mid]>x)
                j=mid-1;
            else 
                i=mid+1;
        }
        return false;
    }
}