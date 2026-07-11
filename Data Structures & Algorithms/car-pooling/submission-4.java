class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for (int[] trip : trips) {
            start = Math.min(start, trip[1]);
            end = Math.max(end, trip[2]);
        }

        int n = end - start + 1;
        int[] memo = new int[n];
        for (int[] trip : trips) {
            memo[trip[1] - start] += trip[0];
            memo[trip[2] - start] -= trip[0];
        }

        int ppl = 0;
        for (int m : memo) {
            ppl += m;
            if (ppl > capacity) {
                return false;
            }
        }
        return true;
    }
}