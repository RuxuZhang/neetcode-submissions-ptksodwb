class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int prevEnd = intervals[0][1];
        int remove = 0;
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start < prevEnd) {
                remove++;
                prevEnd = Math.min(prevEnd, end);
            } else {
                prevEnd = end;
            }
        }
        return remove;
    }
}
