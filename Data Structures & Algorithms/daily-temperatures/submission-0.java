class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty() || temperatures[i] <= stack.peek()[0]) {
                stack.push(new int[]{temperatures[i], i});
            } else {
                while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                    int[] pair = stack.pop();
                    int temp = pair[0];
                    int index = pair[1];
                    res[index] = i - index;
                }
                stack.push(new int[]{temperatures[i], i});
            }
        }

        while (!stack.isEmpty()) {
            int[] pair = stack.pop();
            int index = pair[1];
            res[index] = 0;
        }

        return res;
    }
}
