class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();

        if (s3.length() != n + m) {
            return false;
        }

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[n][m] = true;

        for (int i = n - 1; i >= 0; i--) {
            if (s1.charAt(i) == s3.charAt(i + m)) {
                dp[i][m] = dp[i + 1][m];
            }
        }

        for (int j = m - 1; j >= 0; j--) {
            if (s2.charAt(j) == s3.charAt(j + n)) {
                dp[n][j] = dp[n][j + 1];
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int k = i + j;
                if (s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)) {
                    dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                } else if (s1.charAt(i) == s3.charAt(k)) {
                    dp[i][j] = dp[i + 1][j];
                } else if (s2.charAt(j) == s3.charAt(k)) {
                    dp[i][j] = dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}
