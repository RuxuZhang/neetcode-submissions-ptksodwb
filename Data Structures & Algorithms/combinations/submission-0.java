class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k, new ArrayList<>());
        return res;
    }

    private void backtrack(int i, int n, int k, List<Integer> cur) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (i > n) {
            return;
        }

        cur.add(i);
        backtrack(i + 1, n, k, cur);
        cur.remove(cur.size() - 1);
        backtrack(i + 1, n, k, cur);
    }
}