class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                map.putIfAbsent(i, new ArrayList<>());
                map.putIfAbsent(j, new ArrayList<>());
                map.get(i).add(new int[]{dist, j});
                map.get(j).add(new int[]{dist, i});
            }
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[]{0, 0});
        int ans = 0;
        while (visited.size() < n && !queue.isEmpty()) {
            int[] pair = queue.poll();

            if (visited.contains(pair[1])) {
                continue;
            }
            visited.add(pair[1]);
            ans += pair[0];

            for (int[] nei : map.getOrDefault(pair[1], List.of())) {
                queue.offer(nei);
            }
        }

        return ans;
    }
}
