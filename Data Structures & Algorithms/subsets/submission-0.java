class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        recursion(nums, 0, new ArrayList<>());
        return ans;
    }

    private void recursion(int[] nums, int i, List<Integer> cur) {
        if (i >= nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        recursion(nums, i + 1, cur);
        cur.add(nums[i]);
        recursion(nums, i + 1, cur);
        cur.remove(cur.size() - 1);
    }
}
