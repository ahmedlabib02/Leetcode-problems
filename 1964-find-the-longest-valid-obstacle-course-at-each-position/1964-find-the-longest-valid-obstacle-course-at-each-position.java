import java.util.Arrays;

public class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] dp = new int[n]; // dp array to store the length of the longest non-decreasing subsequence ending at position i
        int[] ans = new int[n]; // array to store the answer

        int len = 0; // current length of the longest subsequence

        for (int i = 0; i < n; i++) {
            int index = binarySearch(dp, len, obstacles[i]);
            dp[index] = obstacles[i];
            ans[i] = index + 1;
            len = Math.max(len, index + 1);
        }

        return ans;
    }

    public int binarySearch(int[] dp, int len, int target) {
        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (dp[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
