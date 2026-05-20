class Solution {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (Integer num : nums) {
            if (!map.containsKey(num)) {
                int prevLen = map.getOrDefault(num - 1, 0);
                int postLen = map.getOrDefault(num + 1, 0);
                int len = prevLen + postLen + 1;
                
                map.put(num, len);

                int leftBd = num - prevLen;
                int rightBd = num + postLen;

                map.put(leftBd, len);
                map.put(rightBd, len);

                max = Math.max(max, len);
            }
        }

        return max;
    }
}
