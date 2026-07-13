import java.util.*;

class Solution {

    private int[][] paths(int m, int n, char[][] grid) {
        int[][] dp = new int[m][n];

        if (grid[0][0] == '#') return dp;

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '#') {
                    dp[i][j] = 0;
                    continue;
                }

                if (i == 0 && j == 0) continue;

                int up = (i > 0) ? dp[i - 1][j] : 0;
                int left = (j > 0) ? dp[i][j - 1] : 0;

                dp[i][j] = up + left;
            }
        }

        return dp;
    }

    private boolean dfs(char[][] grid, int idx, int m, int n, int k) {

        int[][] dp = paths(m, n, grid);

        int total = dp[m - 1][n - 1];

        if (total == k)
            return true;

        if (total < k)
            return false;

        if (idx == m * n)
            return false;

        int r = idx / n;
        int c = idx % n;

      //  if ((r == 0 && c == 0) || (r == m - 1 && c == n - 1))
        //    return dfs(grid, idx + 1, m, n, k);

        // Place obstacle
        grid[r][c] = '#';
        if (dfs(grid, idx + 1, m, n, k))
            return true;

        // Backtrack
        grid[r][c] = '.';

        // Don't place obstacle
        if (dfs(grid, idx + 1, m, n, k))
            return true;

        return false;
    }

    public String[] createGrid(int m, int n, int k) {

        char[][] grid = new char[m][n];

        for (int i = 0; i < m; i++)
            Arrays.fill(grid[i], '.');

        if (!dfs(grid, 0, m, n, k))
            return new String[0];

        String[] ans = new String[m];

        for (int i = 0; i < m; i++)
            ans[i] = new String(grid[i]);

        return ans;
    }
}