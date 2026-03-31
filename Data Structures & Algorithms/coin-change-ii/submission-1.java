class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        Arrays.sort(coins);

        for (int i = coins.length - 1; i >= 0; i--) {
            dp[i][0] = 1;
            for (int a = 1; a <= amount; a++) {
                if (a >= coins[i]) {
                    dp[i][a] = dp[i][a - coins[i]] + dp[i + 1][a];
                }
            }
        }

        return dp[0][amount];
    }
}
