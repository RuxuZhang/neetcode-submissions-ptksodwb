class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        backtrack(0, new int[n], new int[n], n);
        return ans;
    }

    private void backtrack(int row, int[] col, int[] visited, int n) {
        if (row == n) {
            List<String> res = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                String s = "";
                for (int c = 0; c < n; c++) {
                    if (c == col[r]) {
                        s += "Q";
                    } else {
                        s += ".";
                    }
                }
                res.add(s);
            }
            ans.add(res);
        }

        for (int c = 0; c < n; c++) {
            if (visited[c] == 1) continue;

            boolean safe = true;
            for (int prevR = 0; prevR < row; prevR++) {
                int prevC = col[prevR];
                if (Math.abs(row - prevR) == Math.abs(c - prevC)) {
                    safe = false;
                }
            }
            if (!safe) continue;

            visited[c] = 1;
            col[row] = c;
            backtrack(row + 1, col, visited, n);
            visited[c] = 0;
            col[row] = 0;
        }
    }
}
