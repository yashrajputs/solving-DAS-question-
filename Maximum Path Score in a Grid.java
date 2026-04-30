//Approach (Bottom Up)
//T.C : O(m*n*k)
//S.C : O(m*n*k)

class Solution {

    int m, n;
    int[][][] dp;

    public int solve(int[][] grid, int k, int i, int j, int cost) {

        if (i >= m || j >= n) return Integer.MIN_VALUE;

        int newCost = cost + (grid[i][j] > 0 ? 1 : 0);

        if (newCost > k) return Integer.MIN_VALUE;

        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (dp[i][j][cost] != Integer.MIN_VALUE) {
            return dp[i][j][cost];
        }

        int down = solve(grid, k, i + 1, j, newCost);
        int right = solve(grid, k, i, j + 1, newCost);

        int bestNext = Math.max(down, right);

        if (bestNext == Integer.MIN_VALUE) {
            return dp[i][j][cost] = Integer.MIN_VALUE;
        }

        return dp[i][j][cost] = grid[i][j] + bestNext;
    }

    public int maxPathScore(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n][k + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    dp[i][j][c] = Integer.MIN_VALUE;
                }
            }
        }

        int res = solve(grid, k, 0, 0, 0);

        return res == Integer.MIN_VALUE ? -1 : res;
    }
}
