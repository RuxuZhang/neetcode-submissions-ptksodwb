class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreq = new HashMap<>();

        for (int num : nums) {
            numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        numToFreq.forEach((num, freq) -> {
            minHeap.offer(new int[]{num, freq});

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        });

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int[] pair = minHeap.poll();
            ans[i] = pair[0];
        }

        return ans;
    }
}
