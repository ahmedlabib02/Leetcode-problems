class Solution {
    int target ;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        this.target = target;
        backtrack(new ArrayList<>(), ans, 0, 0,candidates);
        return ans;
    }
    public void backtrack(List<Integer> curr, List<List<Integer>> ans, int index, int sum,int[] arr){
        if(sum>target)
            return;
        if(sum==target)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<arr.length;i++)
        {
            if(sum +arr[i]> target)
                break;
            if(i==index || i!=0 && arr[i]!=arr[i-1])
            {
                curr.add(arr[i]);
                backtrack(curr,ans,i+1,sum+arr[i],arr);
                curr.remove(curr.size()-1);
            }
                
            
            
        }
    }
}