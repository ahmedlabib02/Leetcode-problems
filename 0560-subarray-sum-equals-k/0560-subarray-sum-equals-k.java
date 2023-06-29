class Solution {
    public int subarraySum(int[] nums, int k) {
       int sum=0;
       int res=0;
       HashMap<Integer,Integer> map = new HashMap<>();
       map.put(0, 1); 
       for(int num : nums){
           sum+= num;
           int target = sum - k;
           if(map.containsKey(target))
             res+=  map.get(target);
         map.put(sum, map.getOrDefault(sum, 0) + 1);
       } 
        
        return res;
    }
}