class Solution {
    int[][] memo;
    int[][] arr;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        memo = new int[matrix.length][matrix[0].length];
        arr = matrix;
        for (int[] x : memo)
            Arrays.fill(x, -1);

        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (memo[i][j] == -1)
                    ans = Math.max(ans, 1+dp(i, j));
            }
        }
        return ans;
    }

    public int dp(int i, int j) {
        if (memo[i][j] != -1)
            return memo[i][j];

        int up = 0;
        if (i > 0 && arr[i - 1][j] > arr[i][j])
            up = 1 + dp(i - 1, j);

        int down = 0;
        if (i < arr.length - 1 && arr[i + 1][j] > arr[i][j])
            down = 1 + dp(i + 1, j);

        int left = 0;
        if (j > 0 && arr[i][j - 1] > arr[i][j])
            left = 1 + dp(i, j - 1);

        int right = 0;
        if (j < arr[i].length - 1 && arr[i][j + 1] > arr[i][j])
            right = 1 + dp(i, j + 1);

        int temp = Math.max(left, right);
        int temp2 = Math.max(temp, up);
        memo[i][j] = Math.max(temp2, down);
        return memo[i][j];
    }
}
