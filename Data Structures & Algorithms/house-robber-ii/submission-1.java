class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int max1 = helper(Arrays.copyOfRange(nums, 1, nums.length));
        int max2 = helper(Arrays.copyOfRange(nums, 0, nums.length - 1));
        return Math.max(max1, max2);
    }

    private int helper(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        if (n == 1) {
            return nums[0];
        }

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[n - 1];
    }
}
