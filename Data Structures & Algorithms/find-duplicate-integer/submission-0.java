public class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int res = 0;

        for (int b = 0; b <32; b++) {
            int mask = 1 << b;

            int countNum = 0;
            for (int num : nums) {
                if ((num & mask) != 0) {
                    countNum++;
                }
            }

            int count = 0;
            for (int i = 1; i <= n - 1; i++) {
                if ((i & mask) != 0) {
                    count++;
                }
            }

            if (countNum > count) {
                res |= mask;
            }
        }

        return res;
    }
}