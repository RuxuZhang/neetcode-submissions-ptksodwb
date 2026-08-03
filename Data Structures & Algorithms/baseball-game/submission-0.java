class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;
        Stack<Integer> scores = new Stack<>();

        for (int i = 0; i < n; i++) {
            String op = operations[i];
            if (op.equals("+")) {
                if (scores.size() <= 1) {
                    continue;
                }
                Integer prev = scores.peek();
                Integer prevprev = scores.get(scores.size() - 2);
                scores.add(prev + prevprev);
            } else if (op.equals("C")) {
                if (scores.isEmpty()) {
                    continue;
                }
                scores.pop();
            } else if (op.equals("D")) {
                if (scores.isEmpty()) {
                    continue;
                }
                scores.add(scores.peek() * 2);
            } else {
                scores.add(Integer.valueOf(op));
            }
        }

        int ans = 0;
        for (Integer num : scores) {
            num = num == null ? 0 : num;
            ans += num;
        }
        return ans;
    }
}