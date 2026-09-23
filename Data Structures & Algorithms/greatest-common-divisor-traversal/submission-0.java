public class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        boolean[] visit = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (gcd(nums[i], nums[j]) > 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        dfs(0, adj, visit);
        for (boolean node : visit) {
            if (!node) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visit) {
        visit[node] = true;
        for (int nei : adj.get(node)) {
            if (!visit[nei]) {
                dfs(nei, adj, visit);
            }
        }
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}