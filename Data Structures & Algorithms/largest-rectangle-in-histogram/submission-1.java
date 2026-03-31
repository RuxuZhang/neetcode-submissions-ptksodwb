class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];

            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > h) {
                int[] pop = stack.pop();
                int index = pop[0];
                int height = pop[1];
                maxArea = Math.max(maxArea, (i - index) * height);
                start = index;
            }

            stack.push(new int[]{start, h});
        }

        for (int[] pair : stack) {
            int index = pair[0];
            int height = pair[1];
            maxArea = Math.max(maxArea, (heights.length - index) * height);
        }

        return maxArea;
    }
}
