class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] border = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && border[i][0] == 0) {
                dfs(board, i, 0, border);
            }
            if (board[i][m - 1] == 'O' && border[i][m - 1] == 0) {
                dfs(board, i, m - 1, border);
            }
        }

        for (int j = 1; j < m - 1; j++) {
            if (board[0][j] == 'O' && border[0][j] == 0) {
                dfs(board, 0, j, border);
            }
            if (board[n - 1][j] == 'O' && border[n - 1][j] == 0) {
                dfs(board, n - 1, j, border);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && border[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int[][] border) {
        border[i][j] = 1;
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O' && border[x][y] == 0) {
                dfs(board, x, y, border);
            }
        }
    }
}
