class Solution {
    int ans = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, target);

        return ans;
    }

    private void dfs(int[] nums, int i, int rem) {
        if (rem == 0 && i == nums.length) {
            ans++;
            return;
        }

        if (i < nums.length) {
            dfs(nums, i + 1, rem + nums[i]);
            dfs(nums, i + 1, rem - nums[i]);
        }
    }
}
