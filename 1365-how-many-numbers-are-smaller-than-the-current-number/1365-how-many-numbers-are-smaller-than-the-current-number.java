class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sortedArray = nums.clone();
        Arrays.sort(sortedArray);
        int[] output = new int[nums.length];
        for(int i=0;i<nums.length;i++)
            output[i] = binarySearch(sortedArray,nums[i]);
        
        return output;
        
    }
    
    public static int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    int result = -1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            result = mid;
            right = mid-1;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return result;
}
}