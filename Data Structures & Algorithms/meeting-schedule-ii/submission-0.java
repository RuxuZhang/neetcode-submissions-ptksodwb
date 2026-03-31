/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        int[] endTimes = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            for (int j = 0; j < endTimes.length; j++) {
                if (endTimes[j] <= cur.start) {
                    endTimes[j] = cur.end;
                    break;
                }
            }
        }

        int ans = 0;
        for (int t : endTimes) {
            if (t != 0) {
                ans++;
            }
        }

        return ans;
    }
}
