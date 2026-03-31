class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;

        while (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && matrix[i][j] != 101) {
            ans.add(matrix[i][j]);
            matrix[i][j] = 101;

            int ni = i + directions[k][0];
            int nj = j + directions[k][1];
            if (ni < 0 || ni >= matrix.length || nj < 0 || nj >= matrix[0].length || matrix[ni][nj] == 101) {
                k = k + 1 < 4 ? k + 1 : 0;
                ni = i + directions[k][0];
                nj = j + directions[k][1];
            }

            i = ni;
            j = nj;
        }
        
        return ans;
    }
}
