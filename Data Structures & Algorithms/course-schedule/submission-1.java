class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> next = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            next.put(i , new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            next.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int curClass = queue.poll();
            for (int nextClass : next.get(curClass)) {
                indegree[nextClass]--;
                if (indegree[nextClass] == 0) {
                    queue.offer(nextClass);
                }
            }
        }

        for (int ind : indegree) {
            if (ind > 0) {
                return false;
            }
        }
        return true;
    }
}
