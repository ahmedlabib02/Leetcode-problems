class Solution {
    HashSet<List<Integer>> seen; 
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        seen = new HashSet<>();
        backtrack(new ArrayList<>(), ans, nums, new HashSet<>());
        return ans;
    }
    
    public void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums,HashSet<Integer> is) {
        if (curr.size() == nums.length) {
            if(!seen.contains(curr))
            {
                ans.add(new ArrayList<>(curr));
                seen.add(curr); 
            }
               
            
            
            return;
        }
        
        for(int i=0;i<nums.length ;i++) 
        {
                
                
                HashSet<Integer> temp = new HashSet<>(is);
                if(!is.contains(i)) 
                {
                    temp.add(i);
                    curr.add(nums[i]);
                    backtrack(curr, ans, nums, temp);
                    curr.remove(curr.size() - 1); 
                }
                
        }
    }
}