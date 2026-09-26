class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> roomQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            roomQueue.offer(i);
        }
        PriorityQueue<int[]> meetingQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] count = new int[n];
        int[] endTime = new int[n];
        int max = 0;

        for (int[] meeting : meetings) {
            while (!meetingQueue.isEmpty() && meetingQueue.peek()[0] <= meeting[0]) {
                roomQueue.offer(meetingQueue.poll()[1]);
            }

            int room = -1;
            if (!roomQueue.isEmpty()) {
                room = roomQueue.poll();
                int newEndTime = endTime[room] <= meeting[0] ? meeting[1] : endTime[room] + meeting[1] - meeting[0];
                meetingQueue.offer(new int[]{newEndTime, room});
                count[room]++;
                endTime[room] = newEndTime;
            } else {
                int nextEnd = meetingQueue.peek()[0];
                while (!meetingQueue.isEmpty() && meetingQueue.peek()[0] == nextEnd) {
                    roomQueue.offer(meetingQueue.poll()[1]);
                }
                room = roomQueue.poll();
                int newEndTime = nextEnd + (meeting[1] - meeting[0]);
                meetingQueue.offer(new int[]{newEndTime, room});
                count[room]++;
                endTime[room] = newEndTime;
            }

            if (count[room] > max) {
                max = count[room];
            }
        }

        for (int i = 0; i < n; i++) {
            if (count[i] == max) {
                return i;
            }
        }

        return -1;
    }
}