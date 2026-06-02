class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        LinkedList<String> ans = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String src = stack.peek();

            if (adj.containsKey(src) && !adj.get(src).isEmpty()) {
                stack.push(adj.get(src).poll());
            } else {
                ans.addFirst(stack.pop());
            }
        }

        return ans;
    }
}
