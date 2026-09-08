class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int globMax = Integer.MIN_VALUE, globMin = Integer.MAX_VALUE;
        int curMax = 0, curMin = 0;
        int total = 0;

        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            curMin = Math.min(curMin + num, num);
            total += num;
            globMax = Math.max(globMax, curMax);
            globMin = Math.min(globMin, curMin);
        }

        if (globMax < 0) {
            return globMax;
        } else {
            return Math.max(globMax, total - globMin);
        }
    }
}