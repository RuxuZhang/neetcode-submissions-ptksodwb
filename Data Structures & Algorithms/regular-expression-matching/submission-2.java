class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[n][m] = true;

        for (int j = m - 1; j >= 0; j--) {
            if (p.charAt(j) == '*') {
                continue;
            }

            for (int i = n - 1; i >= 0; i--) {
                if (j + 1 < m && p.charAt(j + 1) == '*') {
                    if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
                        dp[i][j] = dp[i + 1][j] || dp[i + 1][j + 2] || dp[i][j + 2];
                    } else {
                        dp[i][j] = dp[i][j + 2];
                    }
                } else if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    if (j + 2 < m && p.charAt(j + 2) == '*') {
                        dp[i][j] = dp[i + 1][j + 1] || dp[i + 1][j + 3];
                    } else {
                        dp[i][j] = dp[i + 1][j + 1];
                    }
                }
            }
        }

        return dp[0][0];
    }
}
