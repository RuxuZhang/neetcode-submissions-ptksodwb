class Solution {
    public boolean canPartition(int[] nums) {
        return dfs(nums, 0, 0, 0);
    }

    private boolean dfs(int[] nums, int i, int sum1, int sum2) {
        if (i == nums.length) {
            return sum1 == sum2;
        }

        boolean go1 = dfs(nums, i + 1, sum1 + nums[i], sum2);
        boolean go2 = dfs(nums, i + 1, sum1, sum2 + nums[i]);

        return go1 || go2;
    }
}
