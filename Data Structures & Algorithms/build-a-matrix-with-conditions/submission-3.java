class Solution {

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] res = new int[k][k];
        
        List<Integer> rowOrder = sort(k, rowConditions);
        List<Integer> colOrder = sort(k, colConditions);

        if (rowOrder == null || colOrder == null) {
            return new int[0][0];
        }

        int count = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (rowOrder.get(i) == colOrder.get(j)) {
                    res[i][j] = rowOrder.get(i);
                    count++;
                }
            }
        }

        if (count != k) {
            return new int[0][0];
        }

        return res;
    }

    private List<Integer> sort(int k, int[][] condition) {
        Map<Integer, Set<Integer>> neighbor = new HashMap<>();
        for (int[] c : condition) {
            neighbor.computeIfAbsent(c[0], f -> new HashSet<>()).add(c[1]);
        }

        int[] indegree = new int[k + 1];
        for (Set<Integer> vs : neighbor.values()) {
            for (Integer v : vs) {
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            Integer u = q.poll();
            order.add(u);

            for (Integer nei : neighbor.getOrDefault(u, new HashSet<>())) {
                indegree[nei]--;

                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        if (order.size() != k) {
            return null;
        }

        return order;
    }
}