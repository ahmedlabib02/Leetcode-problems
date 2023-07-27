class Solution {
    int[][] memo;
    char[][] arr;

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        memo = new int[rows][cols];
        arr = matrix;
        int max = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (memo[i][j] == 0 && arr[i][j] != '0') {
                    max = Math.max(max, dp(i, j));
                } else {
                    max = Math.max(max, memo[i][j]);
                }
            }
        }

        return max;
    }

    public int dp(int i, int j) {
        if (memo[i][j] != 0)
            return memo[i][j];

        int down = (i != arr.length - 1 && arr[i + 1][j] != '0') ? dp(i + 1, j) : 0;
        int right = (j != arr[i].length - 1 && arr[i][j + 1] != '0') ? dp(i, j + 1) : 0;
        int dia = (i != arr.length - 1 && j != arr[i].length - 1 && arr[i + 1][j + 1] != '0') ? dp(i + 1, j + 1) : 0;

        int temp = Math.min(down, Math.min(dia, right));
        temp = (int) Math.sqrt(temp);
        temp++;
        memo[i][j] = temp * temp;

        return memo[i][j];
    }
}
