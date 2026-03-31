class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] prev = new int[]{nums[0], nums[0]};
        int ans = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                prev[0] = 1;
                prev[1] = 1;
                ans = Math.max(ans, 0);
            } else {
                int max = Math.max(nums[i], Math.max(prev[0] * nums[i], prev[1] * nums[i]));
                int min = Math.min(nums[i], Math.min(prev[0] * nums[i], prev[1] * nums[i]));
                ans = Math.max(ans, max);
                prev[0] = max;
                prev[1] = min;
            }
        }
        
        return ans;
    }
}
