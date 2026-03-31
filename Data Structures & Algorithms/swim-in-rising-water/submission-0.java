class Solution {
    int n;

    public int swimInWater(int[][] grid) {
        n = grid.length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        int[][] visited = new int[n][n];
        visited[0][0] = 1;

        while(!minHeap.isEmpty()) {
            int[] tri = minHeap.poll();
            int t = tri[0];
            int i = tri[1];
            int j = tri[2];

            if (i == n - 1 && j == n - 1) {
                return t;
            }

            if (i + 1 < n && visited[i + 1][j] == 0) {
                minHeap.offer(new int[]{Math.max(t, grid[i + 1][j]), i + 1, j});
                visited[i + 1][j] = 1;
            }
            if (i - 1 >= 0 && visited[i - 1][j] == 0) {
                minHeap.offer(new int[]{Math.max(t, grid[i - 1][j]), i - 1, j});
                visited[i - 1][j] = 1;
            }
            if (j + 1 < n && visited[i][j + 1] == 0) {
                minHeap.offer(new int[]{Math.max(t, grid[i][j + 1]), i, j + 1});
                visited[i][j + 1] = 1;
            }
            if (j - 1 >= 0 && visited[i][j - 1] == 0) {
                minHeap.offer(new int[]{Math.max(t, grid[i][j - 1]), i, j - 1});
                visited[i][j - 1] = 1;
            }
        }

        return -1;
    }
}
