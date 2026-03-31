class Solution {
    public int findMin(int[] nums) {
        return findMinimum(nums, 0, nums.length - 1);
    }

    private int findMinimum(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }

        if (nums[i] < nums[j]) {
            return nums[i];
        }

        int m = i + (j - i) / 2;
        if (nums[m] >= nums[i]) {
            return findMinimum(nums, m + 1, j);
        } else {
            return findMinimum(nums, i, m);
        }
    }
}
