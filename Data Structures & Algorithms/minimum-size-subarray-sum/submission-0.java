class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        while (r < n) {
            sum += nums[r];

            if (sum >= target) {
                res = Math.min(res, r - l + 1);
            }

            while (sum >= target && l < r) {
                sum -= nums[l];

                if (sum >= target) {
                    res = Math.min(res, r - l);
                }

                l++;
            }

            r++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}