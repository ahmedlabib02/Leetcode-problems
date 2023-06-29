class Solution {
    public int subarraySum(int[] nums, int k) {
       ArrayList<Integer> list = new ArrayList<>();
       int p1 = 0;
       int p2=0;
       int res= 0;
        while(p1<nums.length){
            int sum=0;
            while(p2<nums.length){
                sum+= nums[p2];
                if(sum==k)
                    res++;
                p2++;
            }
            p1++;
            p2=p1;
        }
        
        return res;
    }
}