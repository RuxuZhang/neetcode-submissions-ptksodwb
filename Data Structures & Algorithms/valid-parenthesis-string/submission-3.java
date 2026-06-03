class Solution {
    int n;
    Boolean[][] memo;

    public boolean checkValidString(String s) {
        n = s.length();
        memo = new Boolean[n + 1][n + 1];
        return dfs(s, 0, 0);
    }

    private boolean dfs(String s, int i, int open) {
        if (open < 0) {
            return false;
        }

        if (i == n) {
            return open == 0;
        }

        if (memo[i][open] != null) {
            return memo[i][open];
        }

        char c = s.charAt(i);
        Boolean res;
        if (c == '(') {
            res =  dfs(s, i + 1, open + 1);
        } else if (c == ')') {
            res =  dfs(s, i + 1, open - 1);
        } else {
            res = dfs(s, i + 1, open + 1) || dfs(s, i + 1, open) || dfs(s, i + 1, open - 1);
        }
        memo[i][open] = res;
        return res;
    }
}
