class Solution {
    Set<List<Integer>> ans = new HashSet<>();
    int n;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        backtrack(nums, 0, res);

        return new ArrayList<>(ans);
    }

    private void backtrack(int[] nums, int i, List<Integer> res) {
        if (i == n) {
            ans.add(new ArrayList<>(res));
            return;
        }

        res.add(nums[i]);
        backtrack(nums, i + 1, res);
        res.remove(res.size() - 1);

        while (i + 1 < n && nums[i + 1] == nums[i]) {
            i++;
        }
        backtrack(nums, i + 1, res);
    }
}
