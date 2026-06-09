class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = 1;
            }
        }

        String res = "";
        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && i - 1 >= 0 && j + 1 < n) {
                    dp[i][j] = dp[i - 1][j + 1];
                }

                if (dp[i][j] == 1 && i - j + 1 >= len) {
                    len = i - j + 1;
                    res = s.substring(j, i + 1);
                }
            }
        }
        
        return res;
    }
}
