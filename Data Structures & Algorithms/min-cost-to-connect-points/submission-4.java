class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];

        int node = 0;
        int ans = 0;
        int next = -1;
        for (int i = 0; i < n - 1; i++) {
            visited[node] = true;

            for (int nei = 0; nei < n; nei++) {
                if (visited[nei]) {
                    continue;
                }

                int distance = Math.abs(points[node][0] - points[nei][0]) + Math.abs(points[node][1] - points[nei][1]);
                dist[nei] = Math.min(dist[nei], distance);
                if (next == -1 || dist[nei] < dist[next]) {
                    next = nei;
                }
            }

            ans += dist[next];
            node = next;
            next = -1;
        }

        return ans;
    }
}
