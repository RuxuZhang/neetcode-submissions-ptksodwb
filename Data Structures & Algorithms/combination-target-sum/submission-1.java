class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        backtrack(nums, 0, target, new ArrayList<>());

        return ans;
    }

    private void backtrack(int[] nums, int start, int rem, List<Integer> cur) {
        if (rem == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (rem - nums[i] < 0) {
                return;
            }
            cur.add(nums[i]);
            backtrack(nums, i, rem - nums[i], cur);
            cur.remove(cur.size() - 1);
        }
    }
}
