class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        int count = 0;
        for (int j = n - 1; j >= 0; j--) {
            for (int i = j; i < n; i++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || dp[i - 1][j + 1] == 1)) {
                    dp[i][j] = 1;
                    count++;
                }
            }
        }

        return count;
    }
}
