class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        int[] mergeInterval = new int[2];

        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        int start = i < intervals.length ? Math.min(intervals[i][0], newInterval[0]) : newInterval[0];
        int end = newInterval[1];

        while (i < intervals.length && intervals[i][0] <= end) {
            end = Math.max(end, intervals[i][1]);
            i++;
        }

        res.add(new int[]{start, end});

        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][2]);
    }
}
