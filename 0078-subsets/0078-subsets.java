class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        backtrack(new ArrayList<>(), ans, nums,-1);
        return ans;
    }
    public void backtrack(List<Integer> curr, List<List<Integer>>ans, int[] nums , int index){
        ans.add(new ArrayList<>(curr));
        if(index==nums.length-1)
            return;
        
        for(int i=index+1;i<nums.length;i++)
        {
            curr.add(nums[i]);
            backtrack(curr,ans,nums,i);
            curr.remove(curr.size()-1);
        }
    }
    
}