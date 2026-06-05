class Solution {
    int n;
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        n = edges.length;
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            if (!union(edge[0], edge[1])) {
                return edge;
            }
        }

        return new int[2];
    }

    private boolean union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        if (rootI == rootJ) {
            return false;
        }

        parent[rootJ] = rootI;

        return true;
    }

    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }

        return find(parent[i]);
    }
}
