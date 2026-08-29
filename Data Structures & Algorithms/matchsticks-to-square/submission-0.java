class Solution {

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        int max = 0;
        for (int stick : matchsticks) {
            sum += stick;
            max = Math.max(max, stick);
        }

        if (sum % 4 != 0) {
            return false;
        }

        int target = sum / 4;
        if (max > target) {
            return false;
        }

        int len = matchsticks.length;
        int n = 1 << len;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int m = 0; m < n; m++) {
            if (dp[m] == -1) {
                continue;
            }

            for (int i = 0; i < len; i++) {
                if (((m >> i) & 1) == 1) {
                    continue;
                }

                int newMask = m | (1 << i);
                if (dp[newMask] != -1) {
                    continue;
                }

                int newSum = dp[m] + matchsticks[i];
                if (newSum <= target) {
                    dp[newMask] = newSum % target;
                }
            }
        }

        return dp[n - 1] == 0;
    }
}