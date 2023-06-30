class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int sum = nums[0];
        int temp = nums[0]%k;
        for(int i=1;i<nums.length;i++){
            sum+= nums[i];
            if(sum%k==0){
                 return true;
            }
            else if( set.contains(sum%k)){
               return true; 
            }
            set.add(temp);
            temp = sum%k;
            
        }
        return false;
        
    }
}