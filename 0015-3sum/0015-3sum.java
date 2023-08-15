class Solution {
    int[] arr;
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        arr =nums;
        List<List<Integer>> ans= new ArrayList<>();
        
        for(int i=0;i<nums.length-1;i++)
        {
            if(i!=0 && nums[i-1]==nums[i])
                continue;
            int ii = i+1;
            int j = nums.length-1;
            int target =-nums[i];
            ans.addAll(getTrip(arr[i],ii, j, target));
        }
        
        return ans;
    }
    public List<List<Integer>> getTrip(int num,int start, int end, int target)
    {
        int i =start;
        int j=end;
        List<List<Integer>> ans = new ArrayList<>();
        while(i<j)
        {
            
            int x = arr[i];
            int y = arr[j];
            
            if(i!=start && x==arr[i-1])
            {
                i++;
                continue;
            }
               
            if(j!=end && y==arr[j+1])
            {    
                j--;
                continue;
            }
               
            if(x+y==target)
            {
                List<Integer> temp  =new ArrayList<>();
                temp.add(num);
                temp.add(x);
                temp.add(y);
                i++;
                j--;
                ans.add(temp);
            }
            else if( x+y>target)
                    j--;
            else i++;
            
        }
        
        return ans;
    }
    
}