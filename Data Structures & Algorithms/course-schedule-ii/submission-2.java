class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> dependents = new HashMap<>();
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            dependents.computeIfAbsent(pre[1], k -> new ArrayList<>()).add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        int[] ans = new int[numCourses];
        while(!queue.isEmpty()) {
            int course = queue.poll();
            ans[index] = course;
            index++;

            for (int pre : dependents.getOrDefault(course, List.of())) {
                indegree[pre]--;
                if (indegree[pre] == 0) {
                    queue.offer(pre);
                }
            }
        }

        if (index < numCourses) {
            return new int[0];
        }

        return ans;
    }
}
