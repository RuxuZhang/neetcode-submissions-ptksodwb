class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        // dp[0][n - 1]
        dp[0][0] = piles[0];
        for (int r = 1; r < n; r++) {
            int l = r;
            dp[l][r] = piles[l];
            l--;
            dp[l][r] = Math.max(piles[l], piles[r]);
            for (; l >= 0; l--) {
                dp[l][r] = Math.max(piles[l], piles[r]) + dp[l + 1][r - 1];
            }
        }

        int sum = 0;
        for (int pile : piles) {
            sum += pile;
        }

        return dp[0][n - 1] > sum - dp[0][n - 1];
    }
}