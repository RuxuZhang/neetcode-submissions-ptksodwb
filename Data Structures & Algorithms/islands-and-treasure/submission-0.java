class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                int[] cur = queue.poll();

                for (int[] dir : directions) {
                    int ni = cur[0] + dir[0];
                    int nj = cur[1] + dir[1];

                    if (ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == 2147483647) {
                        grid[ni][nj] = level + 1;
                        queue.offer(new int[]{ni, nj});
                    }
                }
            }

            level++;
        }
    }
}
