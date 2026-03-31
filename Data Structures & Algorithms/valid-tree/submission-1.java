class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int rootU = findRoot(parent, u);
            int rootV = findRoot(parent, v);

            if (rootU == rootV) {
                return false;
            }

            if (u > v) {
                int tmp = u;
                u = v;
                v = tmp;
            }

            parent[rootV] = rootU;
        }

        int root = findRoot(parent, 0);
        for (int i = 1; i < n; i++) {
            if (findRoot(parent, i) != root) {
                return false;
            }
        }

        return true;
    }

    private int findRoot(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return findRoot(parent, parent[i]);
    }
}
