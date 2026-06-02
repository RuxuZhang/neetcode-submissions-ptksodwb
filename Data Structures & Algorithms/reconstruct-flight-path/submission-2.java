class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        LinkedList<String> ans = new LinkedList<>();
        dfs(adj, "JFK", ans);

        return ans;
    }

    private void dfs(Map<String, PriorityQueue<String>> adj, String src, LinkedList<String> ans) {
        if (adj.containsKey(src)) {
            PriorityQueue<String> neis = adj.get(src);

            while (!neis.isEmpty()) {
                String dst = neis.poll();
                dfs(adj, dst, ans);
            }
        }

        ans.addFirst(src);
    }
}
