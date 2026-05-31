class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> neighborMap = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int[] edge = times[i];
            neighborMap.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        Set<Integer> seen = new HashSet<>();
        int time = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[]{k, 0});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            if (seen.contains(node[0])) {
                continue;
            }

            seen.add(node[0]);
            time = node[1];

            if (seen.size() == n) {
                return time;
            }

            List<int[]> neighbors = neighborMap.getOrDefault(node[0], List.of());
            for (int[] nei : neighbors) {
                if (!seen.contains(nei[0])) {
                    queue.offer(new int[]{nei[0], time + nei[1]});
                }
            }
        }

        return -1;
    }
}
