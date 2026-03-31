class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> remainderToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            if (remainderToIndex.keySet().contains(num)) {
                return new int[]{remainderToIndex.get(num), i};
            }

            remainderToIndex.put(target - num, i);
        }

        return new int[2];
    }
}
