class Solution {
    public void rotate(int[][] matrix) {
        vertical(matrix);
        diagonal(matrix);
    }

    private void vertical(int[][] matrix) {
        int i = 0;
        int j = matrix.length - 1;

        while (i < j) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = tmp;
            i++;
            j--;
        }
    }

    private void diagonal(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
