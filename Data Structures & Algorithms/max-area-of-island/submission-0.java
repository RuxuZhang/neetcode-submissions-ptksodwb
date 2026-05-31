class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int n;
    int m;

    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int[] count = new int[1];
                    dfs(grid, i, j, count);
                    max = Math.max(max, count[0]);
                }
            }
        }

        return max;
    }

    private void dfs(int[][] grid, int i, int j, int[] count) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        count[0]++;

        for (int k = 0; k < 4; k++) {
            int[] dir = directions[k];
            dfs(grid, i + dir[0], j + dir[1], count);
        }
    }
}
