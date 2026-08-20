class NumMatrix {
    int[][] mem;
    int n;
    int m;

    public NumMatrix(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;

        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j];
            }
        }

        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                matrix[i][j] = matrix[i][j - 1] + matrix[i][j];
            }
        }

        mem = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int left = col1 == 0 ? 0 : mem[row2][col1 - 1];
        int up = row1 == 0 ? 0 : mem[row1 - 1][col2];

        int upLeftRow = Math.max(row1 - 1, 0);
        int upLeftCol = Math.max(col1 - 1, 0);
        int upLeft = mem[upLeftRow][upLeftCol];

        int ans = mem[row2][col2];
        if (row1 == 0 && col1 == 0) return ans;
        else if (row1 == 0 || col1 == 0) return ans - left - up;
        else return ans - left - up + upLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */