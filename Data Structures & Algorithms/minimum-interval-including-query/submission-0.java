class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] sq = queries.clone();
        Arrays.sort(sq);

        Map<Integer, Integer> ans = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int i = 0;

        for (int q : sq) {
            while (i < intervals.length && intervals[i][0] <= q) {
                int len = intervals[i][1] - intervals[i][0] + 1;
                pq.offer(new int[]{len, intervals[i][1]});
                i++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < q) {
                pq.poll();
            }

            ans.put(q, pq.isEmpty() ? -1 : pq.peek()[0]);
        }

        int[] res = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            res[j] = ans.get(queries[j]);
        }
        return res;
    }
}
