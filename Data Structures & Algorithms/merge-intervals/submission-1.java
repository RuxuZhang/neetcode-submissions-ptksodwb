class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] prev = stack.peek();
            int[] cur = intervals[i];

            if (cur[0] <= prev[1]) {
                prev[1] = Math.max(cur[1], prev[1]);
                stack.pop();
                stack.push(prev);
            } else {
                stack.push(cur);
            }
        }

        // int[][] ans = new int[stack.size()][2];
        // int i = stack.size() - 1;
        // while(!stack.isEmpty()) {
        //     ans[i] = stack.pop();
        //     i--;
        // }
        return stack.toArray(new int[stack.size()][]);
    }
}
