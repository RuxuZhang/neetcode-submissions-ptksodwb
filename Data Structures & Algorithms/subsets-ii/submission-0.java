class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int n;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            backtrack(nums, i, res);
        }

        return ans;
    }

    private void backtrack(int[] nums, int i, List<Integer> res) {
        if (i == n) {
            if (!ans.contains(res)) {
                ans.add(new ArrayList<>(res));
            }
            return;
        }

        for (int j = i + 1; j <= n; j++) {
            backtrack(nums, j, res);
        }

        res.add(nums[i]);
        for (int j = i + 1; j <= n; j++) {
            backtrack(nums, j, res);
        }
        res.remove(res.size() - 1);
    }
}
