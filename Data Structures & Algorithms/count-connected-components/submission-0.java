class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            parent[rootV] = rootU;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(parent, i));
        }
        return set.size();
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }

        return find(parent, parent[i]);
    }
}
