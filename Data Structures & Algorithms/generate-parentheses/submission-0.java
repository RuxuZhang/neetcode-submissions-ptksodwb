class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n, new StringBuilder(""));
        return ans;
    }

    private void backtrack(int count, int open, int n, StringBuilder sb) {
        if (count == n && open == 0) {
            ans.add(new String(sb.toString()));
        }

        if (count < n) {
            sb.append('(');
            backtrack(count + 1, open + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (open > 0) {
            sb.append(')');
            backtrack(count, open - 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
