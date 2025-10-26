class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans =0;
        ans = getAns(nums1, nums2, ans);
        ans = getAns(nums2, nums1, ans);
        return ans;
    }

    private int getAns(int[] nums1, int[] nums2, int ans) {
        for (int j : nums1) {
            long num1 = (long) j * j;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num2 : nums2) {
                if (num1 % num2 == 0)
                {
                    ans += map.getOrDefault((int)(num1 / num2), 0);
                }

                map.put(num2, map.getOrDefault(num2, 0) + 1);
            }
        }
        return ans;
    }
}