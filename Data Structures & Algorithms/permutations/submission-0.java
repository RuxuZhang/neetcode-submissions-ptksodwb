class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new boolean[nums.length], new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] nums, boolean[] pick, List<Integer> res) {
        if (res.size() == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (pick[i]) {
                continue;
            }

            pick[i] = true;
            res.add(nums[i]);
            backtrack(nums, pick, res);
            pick[i] = false;
            res.remove(res.size() - 1);
        }
    }
}
