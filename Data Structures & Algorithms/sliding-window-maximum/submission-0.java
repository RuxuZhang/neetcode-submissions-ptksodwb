class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int r = 0;
        int l = 0;

        Deque<Integer> q = new LinkedList<>();

        while (r < n) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            q.addLast(r);

            if (q.getFirst() < l) {
                q.removeFirst();
            }

            if (r >= k - 1) {
                ans[l] = nums[q.getFirst()];
                l++;
            }

            r++;
        }

        return ans;
    }
}
