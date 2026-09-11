class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        kSum(4, 0, nums, target, new ArrayList<>());
        return res;
    }

    private void kSum(int k, int start, int[] nums, long target, List<Integer> cur) {
        if (k == 2) {
            int i = start;
            int j = nums.length - 1;
            while (i < j) {
                long sum = (long) nums[i] + nums[j];
                if (sum == target) {
                    List<Integer> ans = new ArrayList<>(cur);
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    res.add(ans);
                    i++;
                    while (i < j && nums[i] == nums[i - 1]) i++;
                    j--;
                    while (j > i && nums[j] == nums[j + 1]) j--;
                } else if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }

            return;
        }

        for (int i = start; i <= nums.length - k; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            cur.add(nums[i]);
            kSum(k - 1, i + 1, nums, (long) target - nums[i], cur);
            cur.remove(cur.size() - 1);
        }
    }
}