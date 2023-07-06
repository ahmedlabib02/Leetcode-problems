class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        
        int min = 100000;
        int i=0;
        int j=i+k-1;
        int ans = 0;
        while(j<nums.length){
            System.out.println(i+" "+j);
            if(nums[j]-nums[i]<min)
                min = nums[j]-nums[i];
                
            
            i++;
            j++; //1 4 7 9
        }
        return min;
    }
}