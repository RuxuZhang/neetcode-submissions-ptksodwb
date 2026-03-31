class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>());

        return ans;
    }

    private void backtrack(int[] candidates, int start, int rem, List<Integer> cur) {
        if (rem == 0) {
            if (!ans.contains(cur)) {
                ans.add(new ArrayList<>(cur));
            }
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (rem - candidates[i] < 0) {
                return;
            }

            cur.add(candidates[i]);
            backtrack(candidates, i + 1, rem - candidates[i], cur);
            cur.remove(cur.size() - 1);
        }
    }
}
