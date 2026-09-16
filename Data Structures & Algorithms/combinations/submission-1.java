class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        for (int start = 1; start <= n - k + 1; start++) {
            backtrack(start, n, k, new ArrayList<>());
        }
        return res;
    }

    private void backtrack(int start, int n, int k, List<Integer> cur) {
        cur.add(start);
        
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            cur.remove(cur.size() - 1);
            return;
        }

        for (int i = start + 1; i <= n; i++) {
            backtrack(i, n, k, cur);
        }
        cur.remove(cur.size() - 1);
    }
}