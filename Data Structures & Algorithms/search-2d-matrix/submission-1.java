class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[n - 1][m - 1]) {
            return false;
        }

        int row = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] <= target) {
                row = i;
            }
        }

        int jl = 0;
        int jr = m - 1;
        while (jl <= jr) {
            int mid = (jl + jr) / 2;
            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][mid] > target) {
                jr = mid - 1;
            } else {
                jl = mid + 1;
            }
        }

        return false;
    }
}
