class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        
        int min = 100000;
        int i=0;
        int j=i+k-1;
        int ans = 0;
        while(j<nums.length){
            if(nums[j]-nums[i]<min)
                min = nums[j]-nums[i];
                
            
            i++;
            j++; 
        }
        return min;
    }
}