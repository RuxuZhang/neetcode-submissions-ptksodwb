class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int max = 0;
        String ans = "";

        for (int l = n - 1; l >= 0; l--) {
            for (int r = l; r < n; r++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 1 || dp[l + 1][r - 1] == 1)) {
                    dp[l][r] = 1;
                    if (r - l + 1 > max) {
                        max = r - l + 1;
                        ans = s.substring(l, r + 1);
                    }
                }
            }
        }

        return ans;
    }
}
