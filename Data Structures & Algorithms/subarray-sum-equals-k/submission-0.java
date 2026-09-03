class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> prefixSum = new HashMap<>();

        int sum = 0;
        int count = 0;
        prefixSum.put(sum, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int target = sum - k;
            count += prefixSum.getOrDefault(target, 0);
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}