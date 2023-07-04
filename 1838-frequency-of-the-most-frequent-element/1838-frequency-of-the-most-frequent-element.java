class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int freq=0;
        int prefix = 0;
        int ans=0;
        int j=0;
        for(int i=0;i<nums.length;){
            if(nums[i]*(i-j)-prefix<=k){
                int duplicates = i-j+1;
                ans = Math.max(ans,duplicates);
                prefix+=nums[i];
                i++;
            }  
           else{
               prefix-=nums[j];
               j++; 
           }  
            System.out.print(prefix+" ");
        }
        return ans;
    }
}