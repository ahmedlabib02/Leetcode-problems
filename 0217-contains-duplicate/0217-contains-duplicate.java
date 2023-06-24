import java.util.Hashtable;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Hashtable<Integer,Integer> duplicates = new Hashtable<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(duplicates.get(nums[i])!=null)
                return true;
            else
                duplicates.put(nums[i],nums[i]);
            }
        return false;
        }
        
}