class Solution {
    int n;
    int m;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;

        int[][] pacific = new int[n][m];
        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, i, 0);
        }
        for (int j = 0; j < m; j++) {
            dfs(heights, pacific, 0, j);
        }

        int[][] atlantic = new int[n][m];
        for (int i = 0; i < n; i++) {
            dfs(heights, atlantic, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            dfs(heights, atlantic, n - 1, j);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    ans.add(List.of(i, j));
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] heights, int[][] visit, int i, int j) {
        visit[i][j] = 1;

        if (i + 1 < n && heights[i + 1][j] >= heights[i][j] && visit[i + 1][j] == 0) {
            dfs(heights, visit, i + 1, j);
        }
        if (j + 1 < m && heights[i][j + 1] >= heights[i][j] && visit[i][j + 1] == 0) {
            dfs(heights, visit, i, j + 1);
        }
        if (i - 1 >= 0 && heights[i - 1][j] >= heights[i][j] && visit[i - 1][j] == 0) {
            dfs(heights, visit, i - 1, j);
        }
        if (j - 1 >= 0 && heights[i][j - 1] >= heights[i][j] && visit[i][j - 1] == 0) {
            dfs(heights, visit, i, j - 1);
        }
    }
}
