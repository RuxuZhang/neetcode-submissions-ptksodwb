class Solution {
    int res = 0;

    public int totalNQueens(int n) {
        for (int i = 0; i < n; i++) {
            Set<int[]> occupies = new HashSet<>();
            occupies.add(new int[]{0, i});
            backtrack(0, i, n, occupies);
        }
        
        return res;
    }

    private void backtrack(int x, int y, int n, Set<int[]> occupies) {
        if (x == n - 1) {
            res++;
            return;
        }

        for (int ny = 0; ny < n; ny++) {
            if (!isValid(x + 1, ny, occupies)) {
                continue;
            }

            int[] next = new int[]{x + 1, ny};
            occupies.add(next);
            backtrack(x + 1, ny, n, occupies);
            occupies.remove(next);
        }
    }

    private boolean isValid(int x, int y, Set<int[]> occupies) {
        for (int[] occ : occupies) {
            if (y == occ[1] || Math.abs(x - occ[0]) == Math.abs(y - occ[1])) {
                return false;
            }
        }
        return true;
    }
}