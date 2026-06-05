class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
