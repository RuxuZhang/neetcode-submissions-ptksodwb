class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int l = 0;
        int r = 0;

        while (r < n) {
            if (nums[l] == val) {
                while (r < n && nums[r] == val) {
                    r++;
                }

                if (r >= n) {
                    break;
                }

                nums[l] = nums[r];
                nums[r] = val;
            }

            l++;
            r++;
        }

        return l;
    }
}