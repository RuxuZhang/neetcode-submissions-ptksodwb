class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        int n = words.length;

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                adj.putIfAbsent(word.charAt(i), new ArrayList<>());
                indegree.put(word.charAt(i), 0);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int len = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() && w1.substring(0, len).equals(w2.substring(0, len))) {
                return "";
            }

            int j = 0;
            while (j < len && w1.charAt(j) == w2.charAt(j)) j++;
            if (j < len) {
                adj.get(w1.charAt(j)).add(w2.charAt(j));
                indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
            }
        }

        StringBuilder sb = new StringBuilder("");
        Queue<Character> queue = new LinkedList<>();

        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            Character c = queue.poll();
            sb.append(String.valueOf(c));

            for (Character nei : adj.get(c)) {
                indegree.put(nei, indegree.get(nei) - 1);
                if (indegree.get(nei) == 0) {
                    queue.offer(nei);
                }
            }
        }

        if (sb.length() != indegree.size()) {
            return "";
        }

        return sb.toString();
    }
}
