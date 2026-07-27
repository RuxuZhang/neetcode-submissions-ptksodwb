class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = sum(stones);
        int target = total / 2;
        int n = stones.length;

        int[] dp = new int[target + 1];

        for (int stone : stones) {
            for (int w = target; w >= stone; w--) {
                dp[w] = Math.max(dp[w], dp[w - stone] + stone);
            }
        }

        return total - dp[target] * 2;
    }

    private int sum(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        return sum;
    }
}