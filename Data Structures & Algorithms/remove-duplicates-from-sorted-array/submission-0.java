class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int l = 0;
        int r = 1;
        while (r < nums.length) {
            while (r < nums.length && nums[r] == nums[l]) {
                r++;
            }

            if (r == nums.length) {
                break;
            }

            l++;
            nums[l] = nums[r];
        }

        return l + 1;
    }
}