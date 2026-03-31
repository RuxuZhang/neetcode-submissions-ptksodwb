class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m];


        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == t.charAt(m - 1)) {
                dp[i][m - 1] = dp[i + 1][m - 1] + 1;
            } else {
                dp[i][m - 1] = dp[i + 1][m - 1];
            }
        }

        for (int j = m - 2; j >= 0; j--) {
            for (int i = n - 1; i >= 0; i--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        return dp[0][0];
    }
}
