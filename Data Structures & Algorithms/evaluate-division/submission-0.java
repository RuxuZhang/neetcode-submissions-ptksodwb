class Solution {

    // DFS
    class Pair {
        String node;
        double weight;

        Pair(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    Map<String, List<Pair>> neighbor;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        neighbor = new HashMap<>();

        int i = 0;
        for (List<String> eq : equations) {
            neighbor.putIfAbsent(eq.get(0), new ArrayList<>());
            neighbor.putIfAbsent(eq.get(1), new ArrayList<>());
            neighbor.get(eq.get(0)).add(new Pair(eq.get(1), values[i]));
            neighbor.get(eq.get(1)).add(new Pair(eq.get(0), 1 / values[i]));
            i++;
        }

        int n = queries.size();
        double[] res = new double[n];
        for (i = 0; i < n; i++) {
            List<String> query = queries.get(i);
            res[i] = dfs(query.get(0), query.get(1), 1d, new HashSet<>());
        }

        return res;
    }

    private double dfs(String s, String e, double v, Set<String> visited) {
        visited.add(s);

        if (!neighbor.containsKey(s)) {
            return -1d;
        }

        if (s.equals(e)) {
            return v;
        }

        double ans = -1d;
        for (Pair nei : neighbor.get(s)) {
            if (visited.contains(nei.node)) {
                continue;
            }

            double cur = dfs(nei.node, e, v * nei.weight, visited);
            if (cur != ans) {
                ans = cur;
                break;
            }
        }
        return ans;
    }
}