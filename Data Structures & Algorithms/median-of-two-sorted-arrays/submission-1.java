class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int n = nums1.length;
        int m = nums2.length;
        int half = (n + m + 1) / 2;
        int l = 0, r = n;

        while (l <= r) {
            int i = (l + r) / 2;
            int j = half - i;

            int left1 = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int right1 = i < n ? nums1[i] : Integer.MAX_VALUE;
            int left2 = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int right2 = j < m ? nums2[j] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                r = i - 1;
            } else {
                l = i + 1;
            }

        }

        return -1;
    }
}
