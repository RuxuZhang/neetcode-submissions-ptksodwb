class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (gcd(nums[i], nums[j]) > 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int[] visited = new int[n];
        dfs(0, adj, visited);

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int i, List<List<Integer>> adj, int[] visited) {
        visited[i] = 1;

        for (int nei : adj.get(i)) {
            if (visited[nei] == 0) {
                dfs(nei, adj, visited);
            }
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
}