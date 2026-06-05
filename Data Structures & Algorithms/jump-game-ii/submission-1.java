class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
                continue;
            }

            int min = Integer.MAX_VALUE;
            for (int k = 1; k <= nums[i] && i + k < n; k++) {
                min = Math.min(min, dp[i + k]);
            }
            dp[i] = min + 1;
        }

        return dp[0];
    }
}
