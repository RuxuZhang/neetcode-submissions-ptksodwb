class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int[] count = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            rooms.offer(i);
        }

        int max = 0;
        for (int m = 0; m < meetings.length; m++) {
            while(!pq.isEmpty() && pq.peek()[0] <= meetings[m][0]) {
                int[] cur = pq.poll();
                System.out.println(String.format("Release room %d", cur[1]));
                rooms.offer(cur[1]);
            }

            if (rooms.isEmpty()) {
                int[] nextEnd = pq.poll();
                int duration = meetings[m][1] - meetings[m][0];
                pq.offer(new int[]{nextEnd[0] + duration, nextEnd[1]});
                count[nextEnd[1]]++;
                System.out.println(String.format("Room %d count to %d", nextEnd[1], count[nextEnd[1]]));
                max = Math.max(max, count[nextEnd[1]]);
            } else {
                int room = rooms.poll();
                pq.offer(new int[]{meetings[m][1], room});
                count[room]++;
                System.out.println(String.format("Room (empty) %d count to %d", room, count[room]));
                max = Math.max(max, count[room]);
            }
        }

        for (int res = 0; res < n; res++) {
            if (count[res] == max) {
                return res;
            }
        }
        return -1;
    }
}