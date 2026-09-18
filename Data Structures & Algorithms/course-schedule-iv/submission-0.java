// Kahn's Algorithm
class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] indegree = new int[numCourses];
        Set<Integer>[] adj = new HashSet[numCourses];
        Set<Integer>[] pres = new HashSet[numCourses];
        
        for (int c = 0; c < numCourses; c++) {
            adj[c] = new HashSet<>();
            pres[c] = new HashSet<>();
        }

        for (int[] pre : prerequisites) {
            indegree[pre[1]]++;
            adj[pre[0]].add(pre[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int c = 0; c < numCourses; c++) {
            if (indegree[c] == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            int c = queue.poll();

            for (int nei : adj[c]) {
                pres[nei].add(c);
                pres[nei].addAll(pres[c]);

                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {           
            ans.add(pres[query[1]].contains(query[0]));
        }
        return ans;
    }
}