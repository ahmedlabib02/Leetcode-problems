class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> sol = new LinkedList<List<Integer>>();
        for(int j=0;j<nums.length-3;j++){
            if(j==0|| (j>0&& nums[j]!=nums[j-1]))
            for (int i = j+1; i < nums.length - 2; i++) {
            if (i == j+1 || (i > j+1 && nums[i] != nums[i - 1])) {
                long t = (long)target - (long)nums[i]- (long)nums[j];
                int left = i + 1;
                int right = nums.length - 1;
                
                while (left < right) {
                    long result = nums[left] + nums[right];
                    if (result == t) {
                        ArrayList<Integer> miniSol = new ArrayList<>();
                        miniSol.add(nums[j]);
                        miniSol.add(nums[i]);
                        miniSol.add(nums[left]);
                        miniSol.add(nums[right]);
                        sol.add(miniSol);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] > t) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
    }
        

        return sol; 
    }
}