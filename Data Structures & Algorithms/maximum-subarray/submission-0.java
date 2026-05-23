class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] m = new int[n];
        m[0] = nums[0];
        int max = m[0];

        for (int i = 1; i < n; i++) {
            m[i] = Math.max(nums[i], m[i - 1] + nums[i]);
            max = Math.max(max, m[i]);
        }

        return max;
    }
}
