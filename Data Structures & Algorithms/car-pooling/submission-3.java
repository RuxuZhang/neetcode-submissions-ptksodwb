class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int n = trips.length;

        int ppl = 0;

        for (int i = 0; i < n; i++) {
            int[] trip = trips[i];
            ppl += trip[0];
            pq.offer(trip);

            while (!pq.isEmpty() && pq.peek()[2] <= trip[1]) {
                int[] off = pq.poll();
                ppl -= off[0];
            }

            if (ppl > capacity) {
                return false;
            }
        }

        return true;
    }
}