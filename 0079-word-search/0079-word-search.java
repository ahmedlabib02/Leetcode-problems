import java.util.HashSet;

class Solution {
    char[][] grid;

    public boolean exist(char[][] board, String word) {
        grid = board;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && backtrack(i, j, word, "", new HashSet<>())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(int i, int j, String word, String s, HashSet<String> visited) {
        String position = i + "," + j;
        if (s.length() == word.length() && !s.equals(word)) {
            return false;
        }
        if (s.length() == word.length() && s.equals(word)) {
            return true;
        }
        if (i == -1 || j == -1 || i == grid.length || j == grid[i].length ) {
            return false;
        }

        boolean right = false;
        boolean down = false;
        boolean left = false;
        boolean up = false;

        if (grid[i][j] == word.charAt(s.length())) {
            String s2 = s+grid[i][j];
            grid[i][j]+=100;
            right = backtrack(i, j + 1, word, s2, visited);
            down = backtrack(i + 1, j, word, s2, visited);
            left = backtrack(i, j - 1, word, s2, visited);
            up = backtrack(i - 1, j, word, s2, visited);
            grid[i][j]-=100; 
        }

        return right || down || up || left;
    }
}
