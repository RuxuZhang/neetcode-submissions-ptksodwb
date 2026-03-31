class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            newNums[i] = nums[i - 1];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int l = n; l >= 1; l--) {
            for (int r = l; r <= n; r++) {
                int max = 0;
                for (int i = l; i <= r; i++) {
                    int coins = newNums[l - 1] * newNums[i] * newNums[r + 1];
                    max = Math.max(max, coins + dp[l][i - 1] + dp[i + 1][r]);
                }
                dp[l][r] = max;
            }
        }

        return dp[1][n];
    }
}
