class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        for (int[] point : points) {
            int x1 = point[0];
            int x2 = point[1];
            int dis = x1 * x1 + x2 * x2;

            maxHeap.offer(new int[] {x1, x2, dis});

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty()) {
                break;
            }
            int[] cur = maxHeap.poll();
            ans[i] = new int[]{cur[0], cur[1]};
        }

        return ans;
    }
}
