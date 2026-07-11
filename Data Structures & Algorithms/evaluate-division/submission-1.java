// Union-Find

class UnionFind {
    Map<String, String> parent;
    Map<String, Double> weight;

    public UnionFind() {
        parent = new HashMap<>();
        weight = new HashMap<>();
    }

    public void add(String x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            weight.put(x, 1d);
        }
    }

    public String find(String x) {
        if (!parent.get(x).equals(x)) {
            String p = parent.get(x);
            parent.put(x, find(p));
            weight.put(x, weight.get(x) * weight.get(p));
        }
        return parent.get(x);
    }

    public void union(String x, String y, double value) {
        add(x);
        add(y);
        String rootX = find(x);
        String rootY = find(y);

        // x / y = value
        // x / rootX = weight.get(x)
        // y / rootY = weight.get(y)
        // rootX / rootY = (value * weight.get(y)) / weight.get(x)

        if (!rootX.equals(rootY)) {
            parent.put(rootX, rootY);
            weight.put(rootX, (value * weight.get(y)) / weight.get(x));
        }
    }

    public double getRatio(String x, String y) {
        if (!parent.containsKey(x) || !parent.containsKey(y)) {
            return -1d;
        }

        String rootX = find(x);
        String rootY = find(y);

        if (!rootX.equals(rootY)) {
            return -1d;
        }

        return weight.get(x) / weight.get(y);
    }
}


class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind uf = new UnionFind();

        int i = 0;
        for (List<String> eq : equations) {
            uf.union(eq.get(0), eq.get(1), values[i]);
            i++;
        }

        int n = queries.size();
        double[] res = new double[n];
        i = 0;
        for (List<String> query : queries) {
            res[i] = uf.getRatio(query.get(0), query.get(1));
            i++;
        }

        return res;
    }
}