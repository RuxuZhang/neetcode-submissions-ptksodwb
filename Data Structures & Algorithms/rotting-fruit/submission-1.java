class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int time = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];

                for (int[] dir : directions) {
                    if (r + dir[0] >= 0 && r + dir[0] < n 
                    && c + dir[1] >= 0 && c + dir[1] < m 
                    && grid[r + dir[0]][c + dir[1]] == 1) {
                        grid[r + dir[0]][c + dir[1]] = 2;
                        queue.offer(new int[]{r + dir[0], c + dir[1]});
                    }
                }
            }
            time++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time == -1 ? 0 : time;
    }
}
