class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] canReach = new boolean[n];
        canReach[0] = true;

        int i = 0;
        while (i < n && canReach[i]) {
            for (int j = i + 1; j <= i + nums[i] && j < n; j++) {
                canReach[j] = true;
            }
            i++;
        }

        return canReach[n - 1];
    }
}
