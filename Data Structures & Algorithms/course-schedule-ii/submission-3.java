class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> mapping = new HashMap<>();
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            mapping.computeIfAbsent(pre[1], f -> new ArrayList<>()).add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans.add(cur);

            if (!mapping.containsKey(cur)) {
                continue;
            }

            for (int next : mapping.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        if (ans.size() != numCourses) {
            return new int[0];
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
