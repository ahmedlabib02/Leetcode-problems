class Solution {
    String s1;
    String s2;
    int[][] memo;

    public int minDistance(String s, String t) {
        s1 = s;
        s2 = t;
        memo = new int[s.length()][t.length()];
        for (int[] x : memo)
            Arrays.fill(x, -1);
        return dp(0, 0);
    }

    public int dp(int i, int j) {
        if (i == s1.length())
            return s2.length() - j;
        if (j == s2.length())
            return s1.length() - i;

        if (memo[i][j] != -1)
            return memo[i][j];

        int skip = Integer.MAX_VALUE;
        if (s1.charAt(i) == s2.charAt(j))
            skip = dp(i + 1, j + 1);

        int delete = dp(i + 1, j) + 1;
        int insert = dp(i, j + 1) + 1;
        int replace = dp(i + 1, j + 1) + 1;

        memo[i][j] = Math.min(delete, Math.min(skip, Math.min(insert, replace)));
        return memo[i][j];
    }
}
