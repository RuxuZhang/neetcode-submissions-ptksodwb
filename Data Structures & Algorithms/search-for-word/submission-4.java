class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int[][] visited = new int[board.length][board[0].length];
                visited[i][j] = 1;
                if (backtrace(board, word, i, j, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtrace(char[][] board, String word, int i, int j, int[][] visited, int k) {

        char cb = board[i][j];
        char cw = word.charAt(k);

        if (cb != cw) {
            return false;
        }

        if (k == word.length() - 1) {
            return true;
        }

        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length && visited[ni][nj] == 0) {
                visited[ni][nj] = 1;
                if (backtrace(board, word, ni, nj, visited, k + 1)) {
                    return true;
                }
                visited[ni][nj] = 0;
            }
        }
        return false;
    }
}
